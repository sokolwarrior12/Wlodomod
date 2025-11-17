package waltuhmod.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;
import waltuhmod.character.Waltuh;
import waltuhmod.powers.TemplarsPower;
import waltuhmod.util.CardStats;

public class Templars extends BaseCard{
    public static final String ID = makeID("Templars");
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
        addToBot(new ApplyPowerAction(p, p, new TemplarsPower(p, magicNumber), magicNumber));

    }
    public Templars(){
        super(ID, info);
        setMagic(baseMagicNumber, MagicNumber);
        setExhaust(true);
    }
}
