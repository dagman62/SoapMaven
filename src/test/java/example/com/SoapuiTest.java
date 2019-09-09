package example.com;

import java.io.IOException;

import org.apache.xmlbeans.XmlException;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestRunner;
import com.eviware.soapui.model.testsuite.TestRunner.Status;
import com.eviware.soapui.support.SoapUIException;

public class SoapuiTest {
	@Test
	public void BrowserLogin() throws XmlException, IOException, SoapUIException {
		System.out.println("BrowserLogin");
		WsdlProject project = new WsdlProject("C:\\temp\\Employee.xml");
		WsdlTestSuite testsuite=project.getTestSuiteByName("Testing");
		// Grab the testcases present in test suite
		for(int i=0;i<testsuite.getTestCaseCount();i++)	{
	      WsdlTestCase testCase =testsuite.getTestCaseAt(i);
		  // Run the testcase
	      TestRunner runner=testCase.run(new PropertiesMap(), false);
	      // AssertJUnit.assertEquals(Status.FINISHED, runner.getStatus());
	      AssertJUnit.assertEquals(Status.FINISHED, runner.getStatus());
		}
	}
}
