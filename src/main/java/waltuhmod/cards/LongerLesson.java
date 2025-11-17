package waltuhmod.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import waltuhmod.character.Waltuh;
import waltuhmod.util.CardStats;

public class LongerLesson extends BaseCard{
    public static final String ID = makeID("LongerLesson");
    private static final CardStats info = new CardStats(
            Waltuh.Meta.CARD_COLOR,
            CardType.SKILL,
            CardRarity.UNCOMMON,
            CardTarget.ENEMY,
            1
    );
    private static final int baseMagicNumber = -1;
    private static final int MagicNumber = -2;

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(m, p, new StrengthPower(m, magicNumber)));
        addToBot(new ApplyPowerAction(m, p, new DexterityPower(m, magicNumber)));
    }
    public LongerLesson(){
        super(ID, info);
        setMagic(baseMagicNumber, MagicNumber);
    }
}
