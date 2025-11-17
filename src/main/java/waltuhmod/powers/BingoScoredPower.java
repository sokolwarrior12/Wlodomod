package waltuhmod.powers;

import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static waltuhmod.Waltuhmod.makeID;

public class BingoScoredPower extends BasePower {
    public static final String POWER_ID = makeID("BingoScoredPower");
    private static final AbstractPower.PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = false;

    public BingoScoredPower(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }

    public void onInitialApplication() {
        for (int i = 0; i < AbstractDungeon.player.hand.group.size(); i++) {
            AbstractDungeon.player.hand.group.get(i).glowColor = Color.BLUE.cpy();
        }
        for (int i = 0; i < AbstractDungeon.player.masterDeck.group.size(); i++) {
            AbstractDungeon.player.masterDeck.group.get(i).glowColor = Color.BLUE.cpy();
        }
    }

    @Override
    public void atStartOfTurnPostDraw() {
        addToBot(new ApplyPowerAction(owner, owner, new GlowRemove(owner, 1)));
    }

    @Override
    public void onApplyPower(AbstractPower power, AbstractCreature target, AbstractCreature source) {
        super.onApplyPower(power, target, source);
        if (power.ID == BingoPower.POWER_ID) {
            addToTop(new RemoveSpecificPowerAction(owner, owner, this));
        }
    }
}
