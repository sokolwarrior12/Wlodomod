package waltuhmod.relics;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.watcher.MasterRealityPower;
import waltuhmod.character.Waltuh;

import static waltuhmod.Waltuhmod.makeID;

public class PinkLunchBox extends BaseRelic {
    private static final String NAME = "PinkLunchBox";
    public static final String ID = makeID(NAME);
    private static final RelicTier RARITY = RelicTier.STARTER;
    private static final LandingSound SOUND = LandingSound.HEAVY;

    @Override
    public void atBattleStart(){
        addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new MasterRealityPower(AbstractDungeon.player)));

    }

    public PinkLunchBox(){
        super(ID, NAME, Waltuh.Meta.CARD_COLOR, RARITY, SOUND);
    }
}