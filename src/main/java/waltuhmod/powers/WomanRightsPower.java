package waltuhmod.powers;


import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.InvinciblePower;

import static waltuhmod.Waltuhmod.makeID;

public class WomanRightsPower extends BasePower {
    public static final String POWER_ID = makeID("WomanRightsPower");
    private static final AbstractPower.PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = false;

    public WomanRightsPower(AbstractCreature owner, int amount){
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }
    public void atStartOfTurnPostDraw() {
            this.addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, InvinciblePower.POWER_ID));
            this.addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, this.ID));
        }

}
