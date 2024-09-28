package assignment1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalcInterestTest {

    // Test for valid home loan: loanAmount < 100000 and yearLoan <= 5
    @Test
    public void testHomeLoan_LessThan100000_YearLoanLessThan5() {
        String expected = "Total Amount to be Paid: $66000.00\nTotal Interest: $16000.00\nInterest Rate: 8.00%\nInterest Term: 4 years";
        assertEquals(expected, CalcInterest.computeLoanInterest(50000, 4, 1));
    }

    // Test for valid home loan: loanAmount < 100000 and yearLoan between 6 and 10
    @Test
    public void testHomeLoan_LessThan100000_YearLoanBetween6And10() {
        String expected = "Total Amount to be Paid: $116400.00\nTotal Interest: $36400.00\nInterest Rate: 6.50%\nInterest Term: 7 years";
        assertEquals(expected, CalcInterest.computeLoanInterest(80000, 7, 1));
    }

    // Test for valid home loan: loanAmount < 100000 and yearLoan >= 11
    @Test
    public void testHomeLoan_LessThan100000_YearLoanMoreThan11() {
        String expected = "Total Amount to be Paid: $154350.00\nTotal Interest: $64350.00\nInterest Rate: 5.50%\nInterest Term: 13 years";
        assertEquals(expected, CalcInterest.computeLoanInterest(90000, 13, 1));
    }

    // Test for valid property loan: loanAmount < 100000 and yearLoan <= 5
    @Test
    public void testPropertyLoan_LessThan100000_YearLoanLessThan5() {
        String expected = "Total Amount to be Paid: $74868.00\nTotal Interest: $19818.00\nInterest Rate: 12.00%\nInterest Term: 3 years";
        assertEquals(expected, CalcInterest.computeLoanInterest(55050, 3, 2));
    }

    // Test for valid property loan: loanAmount < 100000 and yearLoan >= 11
    @Test
    public void testPropertyLoan_LessThan100000_YearLoanMoreThan11() {
        String expected = "Total Amount to be Paid: $178590.40\nTotal Interest: $81530.40\nInterest Rate: 7.00%\nInterest Term: 12 years";
        assertEquals(expected, CalcInterest.computeLoanInterest(97060, 12, 2));
    }

    // Test for invalid input: negative loan amount
    @Test
    public void testInvalidNegativeLoanAmount() {
        assertEquals("-1", CalcInterest.computeLoanInterest(-50000, 5, 1));
    }

    // Test for invalid input: zero loan amount
    @Test
    public void testInvalidZeroLoanAmount() {
        assertEquals("-1", CalcInterest.computeLoanInterest(0, 5, 1));
    }

    // Test for invalid input: negative loan years
    @Test
    public void testInvalidNegativeLoanYears() {
        assertEquals("-1", CalcInterest.computeLoanInterest(50000, -5, 1));
    }

    // Test for invalid input: zero loan years
    @Test
    public void testInvalidZeroLoanYears() {
        assertEquals("-1", CalcInterest.computeLoanInterest(50000, 0, 1));
    }

    // Test for invalid input: non-existing loan type
    @Test
    public void testInvalidLoanType() {
        assertEquals("-1", CalcInterest.computeLoanInterest(50000, 5, 3));
    }
}
