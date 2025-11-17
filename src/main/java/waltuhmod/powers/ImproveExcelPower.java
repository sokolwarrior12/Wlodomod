package waltuhmod.powers;

import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;

import static waltuhmod.Waltuhmod.makeID;

public class ImproveExcelPower extends BasePower {
    public static final String ID = makeID("ImproveExcelPower");

    @Override
    public void onInitialApplication() {
        super.onInitialApplication();
        addToBot(new RemoveSpecificPowerAction(owner, owner, this));
    }

    public ImproveExcelPower(AbstractCreature owner, int amount){
        super(ID, PowerType.BUFF, false, owner, amount);
    }

}
