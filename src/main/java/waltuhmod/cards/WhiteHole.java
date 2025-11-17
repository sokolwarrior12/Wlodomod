package waltuhmod.cards;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDrawPileAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import waltuhmod.character.Waltuh;
import waltuhmod.util.CardStats;

public class WhiteHole extends BaseCard{
    public static final String ID = makeID("WhiteHole");
    private static final CardStats info =new CardStats(
            Waltuh.Meta.CARD_COLOR,
            AbstractCard.CardType.SKILL,
            CardRarity.SPECIAL,
            AbstractCard.CardTarget.SELF,
            1
    );
    private static final int BLOCK = 8;
    private static final int UPG_BLOCK = 4;
    @Override
    public void use(AbstractPlayer p, AbstractMonster m){
        addToBot(new GainBlockAction(p, block));
        addToBot(new MakeTempCardInDrawPileAction(new Salt(), 1, true, true, false));
    }
    public WhiteHole(){
        super(ID, info);
        setBlock(BLOCK, UPG_BLOCK);
        setExhaust(true);
    }
}
