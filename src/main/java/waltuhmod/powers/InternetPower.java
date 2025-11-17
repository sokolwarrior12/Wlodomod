package waltuhmod.powers;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.*;

import java.math.BigDecimal;
import java.math.MathContext;

import static waltuhmod.Waltuhmod.makeID;

public class InternetPower extends BasePower{
    public static final String POWER_ID = makeID("InternetPower");
    private static final AbstractPower.PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = true;

    public InternetPower(AbstractCreature owner, int amount){
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }

    public void reducePower(int reduceAmount) {
        this.fontScale = 8.0F;
        this.amount -= reduceAmount;
        if (this.amount == 0) {
            this.addToTop(new RemoveSpecificPowerAction(this.owner, this.owner, POWER_ID));
        }

        if (this.amount >= 1471) {
            this.amount = 1471;
        }
    }
    public void stackPower(int stackAmount){
        this.amount+= stackAmount;
        if (this.amount >= 1471) {
            this.amount = 1471;
        }
    }
    public void atStartOfTurnPostDraw() {
        addToTop(new ApplyPowerAction(owner, owner, new DexterityPower(owner, this.amount/2)));
        addToTop(new ApplyPowerAction(owner, owner, new LoseDexterityPower(owner, this.amount/2)));
    }
}