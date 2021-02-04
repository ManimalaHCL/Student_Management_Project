package TestSuites;
import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.TestNG;
import org.testng.annotations.Test;


public class TestCases extends TestBase
{

    @Test(dataProvider = "StudentData",priority=1)
    public void fillUserForm(String name, String subject1,String subject2,String subject3,String subject4,String subject5) throws InterruptedException
    {
    	WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
		username.sendKeys("admin");
		WebElement password=driver.findElement(By.name("password"));
		password.sendKeys("pass");
		WebElement login_button=driver.findElement(By.xpath("//button[text()='Login']"));
		login_button.click();
		Thread.sleep(2000);
		WebElement add_student=driver.findElement(By.xpath("//a[contains(text(),'Add Student')]"));
		add_student.click();
        WebElement name1=driver.findElement(By.xpath("//input[@id='name']"));
        System.out.println("Entering the Name of the Student" +name);
		name1.sendKeys(name);
		WebElement subject_01=driver.findElement(By.xpath("//app-create-student/div/form/div[2]/input"));
		System.out.println("Entering the Subject 1 Mark" + subject1);
		subject_01.sendKeys(subject1);
		WebElement subject_02=driver.findElement(By.xpath("//app-create-student/div/form/div[3]/input"));
		System.out.println("Entering the Subject 2 Mark" +subject2);
		subject_02.sendKeys(subject2);
		WebElement subject_03=driver.findElement(By.xpath("//app-create-student/div/form/div[4]/input"));
		System.out.println("Entering the Subject 3 Mark"+subject3);
		subject_03.sendKeys(subject3);
		WebElement subject_04=driver.findElement(By.xpath("//app-create-student/div/form/div[5]/input"));
		System.out.println("Entering the Subject 4 Mark"+subject4);
	    subject_04.sendKeys(subject4);
		WebElement subject_05=driver.findElement(By.xpath("//app-create-student/div/form/div[6]/input"));
		System.out.println("Entering the Subject 5 Mark"+subject5);
		subject_05.sendKeys(subject5);
		Select select=new Select(driver.findElement(By.xpath("//select[@id='passpercentage']")));
		select.selectByIndex(0);
		WebElement submit_button=driver.findElement(By.xpath("//button[@class='btn btn-success']"));
		submit_button.submit();
		Thread.sleep(2000);
		WebElement student_list=driver.findElement(By.partialLinkText("Student List"));
		student_list.click();
		driver.navigate().refresh();
		WebElement logout=driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		logout.click();
    }
    @Test(priority=2)
	public void login_as_student() throws InterruptedException, ParseException
	{
    	System.out.println("Login As a Student");
    	WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
		username.sendKeys("student");
		WebElement password=driver.findElement(By.name("password"));
		password.sendKeys("pass");
		WebElement login_button=driver.findElement(By.xpath("//button[text()='Login']"));
		login_button.click();
		Thread.sleep(2000);
		WebElement details=driver.findElement(By.xpath("//tbody/tr[1]/td[7]/button"));
		details.click();
		Thread.sleep(4000);
		WebElement title=driver.findElement(By.xpath("//h2[contains(text(),'Student Details')]"));
		String title_student=title.getText();
		System.out.println(title_student);
		for(int i=1;i<7;i++)
		{
	    WebElement student_details=driver.findElement(By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/app-student-details[1]/div[1]/div["+ i +"]"));
	    String data=student_details.getText();
	    System.out.println(data);
		}
	}
		
	@Test(priority=3)
	public void deleting_Student() throws InterruptedException {
		WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
		username.sendKeys("admin");
		WebElement password=driver.findElement(By.name("password"));
		password.sendKeys("pass");
		WebElement login_button=driver.findElement(By.xpath("//button[text()='Login']"));
		login_button.click();
		Thread.sleep(2000);
		WebElement delete_button=driver.findElement(By.xpath("//tbody/tr[1]/td[8]/button[1]"));
		delete_button.click();
		System.out.println("Student Details Deleted Successfully");
		}
	
	@Test(priority=4)
	public void updating_the_Student() throws Exception
	{
		WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
		username.sendKeys("admin");
		WebElement password=driver.findElement(By.name("password"));
		password.sendKeys("pass");
		WebElement login_button=driver.findElement(By.xpath("//button[text()='Login']"));
		login_button.click();
		Thread.sleep(2000);
		WebElement update=driver.findElement(By.xpath("//tbody/tr[1]/td[8]/button[3]"));
		update.click();
		Thread.sleep(2000);
		WebElement update_label=driver.findElement(By.xpath("//app-update-student/h3"));
		String Update_label=update_label.getText();
		System.out.println(Update_label);
		WebElement name1=driver.findElement(By.xpath("//input[@id='name']"));
		name1.clear();
		name1.sendKeys("Roja");
		WebElement subject_01=driver.findElement(By.xpath("//app-update-student/div/form/div[2]/input[1]"));
		subject_01.clear();
		subject_01.sendKeys("90");
		WebElement submit_update=driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
		submit_update.click();
		Thread.sleep(4000);
		WebElement student_list=driver.findElement(By.partialLinkText("Student List"));
		student_list.click();
		System.out.println("Updated Successfully");
	}
	// Displaying the Student Details after clicking on Details button on the Student List page using the Admin login
	@Test(priority=5)
	public void displaying_Student_details() throws Exception
	{
		System.out.println("Login As an Admin");
    	WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
		username.sendKeys("admin");
		WebElement password=driver.findElement(By.name("password"));
		password.sendKeys("pass");
		WebElement login_button=driver.findElement(By.xpath("//button[text()='Login']"));
		login_button.click();
		Thread.sleep(2000);
		WebElement details=driver.findElement(By.xpath("//tbody/tr[1]/td[8]/button[2]"));
		details.click();
		Thread.sleep(4000);
		WebElement title=driver.findElement(By.xpath("//h2[contains(text(),'Student Details')]"));
		String title_student=title.getText();
		System.out.println(title_student);
		for(int i=1;i<7;i++)
		{
			WebElement student_details=driver.findElement(By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/app-student-details[1]/div[1]/div["+i+"]"));
			String details_01=student_details.getText();
			System.out.println(details_01);
		}
		
		WebElement back_button=driver.findElement(By.xpath("//button[contains(text(),'Back to Student List')]"));
		back_button.click();
		driver.navigate().refresh();
		WebElement logout=driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		logout.click();
	}
	
	
}
