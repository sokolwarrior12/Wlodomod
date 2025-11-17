package waltuhmod.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import waltuhmod.character.Waltuh;
import waltuhmod.util.CardStats;

public class Salt extends BaseCard{
    public static final String ID = makeID("Salt");
    private static final CardStats info =new CardStats(
            Waltuh.Meta.CARD_COLOR,
            AbstractCard.CardType.SKILL,
            AbstractCard.CardRarity.SPECIAL,
            AbstractCard.CardTarget.SELF,
            2
    );
    private static final int baseMagicNumber = 1;
    private static final int MagicNumber = 2;
    private static final int BLOCK = 8;
    private static final int UPG_BLOCK = 12;
    @Override
    public void use(AbstractPlayer p, AbstractMonster m){
        addToBot(new GainBlockAction(p, block));
        addToBot(new ApplyPowerAction(p, p, new StrengthPower(p, magicNumber), magicNumber));
        addToBot(new ApplyPowerAction(p, p, new DexterityPower(p, magicNumber), magicNumber));

    }
    public Salt(){
        super(ID, info);
        setBlock(BLOCK, UPG_BLOCK);
        setMagic(baseMagicNumber, MagicNumber);
        setExhaust(true);
    }
}
