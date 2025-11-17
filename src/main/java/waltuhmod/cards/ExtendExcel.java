package waltuhmod.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import waltuhmod.character.Waltuh;
import waltuhmod.util.CardStats;

public class ExtendExcel extends BaseCard{
    public static final String ID= makeID("ExtendExcel");
    private static final CardStats info = new CardStats(
            Waltuh.Meta.CARD_COLOR,CardType.POWER, CardRarity.UNCOMMON, CardTarget.SELF, 1
    );

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

    }
    public ExtendExcel(){
        super(ID, info);
    }
}
