package waltuhmod.cards;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDrawPileAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import waltuhmod.character.Waltuh;
import waltuhmod.util.CardStats;
import java.util.Random;

public class Uranium extends BaseCard{
    public static final String ID = makeID("Uranium");
    private static final CardStats info =new CardStats(
            Waltuh.Meta.CARD_COLOR,
            AbstractCard.CardType.SKILL,
            AbstractCard.CardRarity.COMMON,
            AbstractCard.CardTarget.SELF,
            1
    );
    static Random random = new Random();
    private static final int BLOCK = 8;
    private static final int UPG_BLOCK = 4;
    @Override
    public void use(AbstractPlayer p, AbstractMonster m){
        addToBot(new GainBlockAction(p, block));
        if(random.nextBoolean()){
            addToBot(new MakeTempCardInDrawPileAction(new Internet(), 1, true, true, false));
        }
        else{
            addToBot(new MakeTempCardInDrawPileAction(new Templars(), 1, true, true, false));
        }
    }
    public Uranium(){
        super(ID, info);
        setBlock(BLOCK, UPG_BLOCK);
    }
}
