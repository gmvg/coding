package coding;

import static org.testng.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gmvg.coding.sorting.Card;
import com.google.common.collect.Comparators;

public class CardTestCase {
	
	private Logger log = Logger.getLogger(CardTestCase.class.getName());

	@Test(dataProvider="unOrderList")
    public void testCardSort(List<Card> cards) {
        Collections.sort(cards);
        assertTrue(cards.get(0).getNumber() == cards.stream().
        		min(Comparator.comparing(Card::getNumber)).get().getNumber());
    }
    
    @DataProvider
    public Object[][] unOrderList() {
    	return new Object[][] {
    			{ Arrays.asList(new Card("",2), new Card("",1))},
    			{ Arrays.asList(new Card("",-1), new Card("",22))}
    	};
    }
}