package rest.assertions;

import org.assertj.core.api.SoftAssertionError;
import org.assertj.core.api.SoftAssertions;

import org.junit.Assert;
import  org.junit.Assert.*;
import rest.exceptions.RestAssertionError;
import rest.exceptions.RestExceptionBase;

import static org.junit.Assert.assertTrue;

public class RestAssuredValidations {

    private static SoftAssertions getSoftAssertion() {return new SoftAssertions();}
    public static void assertTrue(boolean condition) { assertTrue("",condition);}

    public static void assertTrue(String message, boolean condition, boolean... isSoft){
        if(isSoft.length>0){
            try{
                getSoftAssertion().assertThat(condition).as(message).isTrue();
                getSoftAssertion().assertAll();
            } catch(SoftAssertionError e){
                e.printStackTrace();
            }
        } else {
            try{
                Assert.assertTrue(message, condition);
            } catch (AssertionError error){
                throw new RestExceptionBase(message, error);
            }
        }
    }

    public static void assertFalse(boolean condition){assertFalse("",condition);}
    public static void assertFalse(String message, boolean condition){
        try{
            Assert.assertFalse(message, condition);
        } catch(AssertionError error){
            throw new RestAssertionError(error);
        }
    }

    public static void assertEquals(String message, String expected, String actual){
        try{
            doAssertEqualReg(message, expected, actual);
        }catch (AssertionError error){
            throw new RestAssertionError(error);
        }
    }

    private static void doAssertEqualReg(String message, String expected, String actual) {
     try{
         Assert.assertEquals(message, expected, actual);
     } catch (AssertionError error){
         throw new RestAssertionError(error);
     }
    }

    public static void assertEquals(String message, Object expected,Object actual){
        try{
            Assert.assertEquals(message, expected,actual);
        } catch(AssertionError error){
            throw new RestAssertionError(error);
        }
    }
}
