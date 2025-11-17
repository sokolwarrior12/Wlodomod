package waltuhmod.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.InvinciblePower;
import waltuhmod.character.Waltuh;
import waltuhmod.powers.WomanRightsPower;
import waltuhmod.util.CardStats;

public class WomanRights extends BaseCard{
    public static final String ID = makeID("WomanRights");
    private static final CardStats info = new CardStats(
            Waltuh.Meta.CARD_COLOR,
            CardType.POWER,
            CardRarity.UNCOMMON,
            CardTarget.SELF,
            2
    );

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new InvinciblePower(p, 0)));
        addToBot(new ApplyPowerAction(p, p, new WomanRightsPower(p, 1)));

    }
    public WomanRights(){
        super(ID, info);
        setInnate(false, true);
        setSelfRetain(false, true);
    }
}
