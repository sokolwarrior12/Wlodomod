package waltuhmod.cards;

import basemod.helpers.CardTags;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import waltuhmod.character.Waltuh;
import waltuhmod.util.CardStats;

public class Defend extends BaseCard{
    public static final String ID = makeID("Defend");
    private static final CardStats info =new CardStats(
            Waltuh.Meta.CARD_COLOR,
            AbstractCard.CardType.SKILL,
            AbstractCard.CardRarity.BASIC,
            AbstractCard.CardTarget.SELF,
            1
    );
    private static final int BLOCK = 5;
    private static final int UPG_BLOCK = 3;
    @Override
    public void use(AbstractPlayer p, AbstractMonster m){
    addToBot(new GainBlockAction(p, block));

    }
    public Defend(){
        super(ID, info);
        setBlock(BLOCK, UPG_BLOCK);
        tags.add(CardTags.STARTER_DEFEND);
    }

}
