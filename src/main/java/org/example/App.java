package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        String accountNameUserTest = "Applanatest1";
        String accountPasswordUserTest = "Student2020!";
        String projectName = "SeleniumWebDriverTest";
        String companyTitleUserTest = "GeekBrains1";
        String firstNameUserTest = "James";
        String lastNameUserTest = "Bond";
        String jobTitleUserTest = "Agent";


        new CRMCreateProject().createProject(accountNameUserTest,
                accountPasswordUserTest,
                projectName,
                companyTitleUserTest,
                lastNameUserTest,
                firstNameUserTest);

        new CRMDeleteProject().deleteProject(accountNameUserTest,
                accountPasswordUserTest,
                projectName);



    }
}
