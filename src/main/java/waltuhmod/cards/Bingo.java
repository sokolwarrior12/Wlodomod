package waltuhmod.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import waltuhmod.CustomTags;
import waltuhmod.character.Waltuh;
import waltuhmod.powers.BingoPower;
import waltuhmod.util.CardStats;

public class Bingo extends BaseCard{
    public static final String ID = makeID("Bingo");
    private static final CardStats info =new CardStats(
            Waltuh.Meta.CARD_COLOR,
            CardType.POWER,
            CardRarity.RARE,
            CardTarget.SELF,
            1
    );
    private static final int MagicNumber = 5;
    private static final int UPG_MagicNumber = -2;

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new BingoPower(p, magicNumber)));
    }
    public Bingo(){
        super(ID, info);
        setMagic(MagicNumber, UPG_MagicNumber);
        tags.add(CustomTags.BINGO);
    }

}
