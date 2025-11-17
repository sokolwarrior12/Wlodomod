package waltuhmod.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DexterityPower;
import waltuhmod.character.Waltuh;
import waltuhmod.util.CardStats;

public class Internet extends BaseCard{
    public static final String ID = makeID("Internet");
    private static final CardStats info =new CardStats(
            Waltuh.Meta.CARD_COLOR,
            CardType.POWER,
            AbstractCard.CardRarity.SPECIAL,
            AbstractCard.CardTarget.SELF,
            1
    );
    private static final int baseMagicNumber = 1;
    private static final int MagicNumber = 1;
    @Override
    public void use(AbstractPlayer p, AbstractMonster m){
        addToBot(new ApplyPowerAction(p, p, new DexterityPower(p, magicNumber), magicNumber));

    }
    public Internet(){
        super(ID, info);
        setMagic(baseMagicNumber, MagicNumber);
        setExhaust(true);
    }
}
