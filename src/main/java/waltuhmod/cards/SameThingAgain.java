package waltuhmod.cards;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import waltuhmod.character.Waltuh;
import waltuhmod.util.CardStats;

import static com.megacrit.cardcrawl.cards.AbstractCard.CardTarget.SELF;
import static com.megacrit.cardcrawl.cards.AbstractCard.CardType.SKILL;

public class SameThingAgain extends BaseCard{
    public static final String ID = makeID("SameThingAgain");
    private static final CardStats info = new CardStats(
            Waltuh.Meta.CARD_COLOR,
            SKILL,
            CardRarity.RARE,
            SELF,
            1
    );

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if(AbstractDungeon.actionManager.cardsPlayedThisCombat.size() >=2 && (AbstractDungeon.actionManager.cardsPlayedThisCombat.get(AbstractDungeon.actionManager.cardsPlayedThisCombat.size() - 2)).cardID != this.ID && ((AbstractCard)AbstractDungeon.actionManager.cardsPlayedThisCombat.get(AbstractDungeon.actionManager.cardsPlayedThisCombat.size() - 2)).target == CardTarget.SELF){
            (AbstractDungeon.actionManager.cardsPlayedThisCombat.get(AbstractDungeon.actionManager.cardsPlayedThisCombat.size() - 2)).use(p, m);
        }

    }
    public SameThingAgain(){
        super(ID, info);
        setExhaust(true, false);
    }
}
