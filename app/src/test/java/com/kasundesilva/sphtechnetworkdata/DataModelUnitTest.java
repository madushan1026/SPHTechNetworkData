package com.kasundesilva.sphtechnetworkdata;

import com.kasundesilva.sphtechnetworkdata.models.AnnualDataInfo;
import com.kasundesilva.sphtechnetworkdata.repositories.DataUsageRepository;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class DataModelUnitTest {

    @Test
    public void test_isDecreased_with_Q2() {
        AnnualDataInfo aAnnualDataInfo = new AnnualDataInfo("2018", 5, 3, 4, 5);
        assertEquals(aAnnualDataInfo.isDecreased(), true);
        assertEquals(aAnnualDataInfo.getDownTredingQuater(),"Q2");
    }

    @Test
    public void test_isDecreased_with_Q3() {
        AnnualDataInfo aAnnualDataInfo = new AnnualDataInfo("2018", 5, 6, 4, 7);
        assertEquals(aAnnualDataInfo.isDecreased(), true);
        assertEquals(aAnnualDataInfo.getDownTredingQuater(),"Q3");
    }

    @Test
    public void test_isDecreased_with_Q4() {
        AnnualDataInfo aAnnualDataInfo = new AnnualDataInfo("2018", 5, 6, 7, 5);
        assertEquals(aAnnualDataInfo.isDecreased(), true);
        assertEquals(aAnnualDataInfo.getDownTredingQuater(),"Q4");
    }
}
