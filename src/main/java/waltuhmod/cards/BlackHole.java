package waltuhmod.cards;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDrawPileAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import waltuhmod.character.Waltuh;
import waltuhmod.util.CardStats;

public class BlackHole extends BaseCard{
    public static final String ID = makeID("BlackHole");
    private static final CardStats info =new CardStats(
            Waltuh.Meta.CARD_COLOR,
            AbstractCard.CardType.SKILL,
            AbstractCard.CardRarity.COMMON,
            AbstractCard.CardTarget.SELF,
            1
    );
    private static final int BLOCK = 8;
    private static final int UPG_BLOCK = 4;
    @Override
    public void use(AbstractPlayer p, AbstractMonster m){
        addToBot(new GainBlockAction(p, block));
        addToBot(new MakeTempCardInDrawPileAction(new WhiteHole(), 1, true, true, false));
    }
    public BlackHole(){
        super(ID, info);
        setBlock(BLOCK, UPG_BLOCK);
    }

}
