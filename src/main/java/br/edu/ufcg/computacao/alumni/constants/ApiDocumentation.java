package br.edu.ufcg.computacao.alumni.constants;

public class ApiDocumentation {
    public static class ApiInfo {
        public static final String CONTACT_NAME = "Computação@UFCG";
        public static final String CONTACT_URL = "https://computacao.ufcg.edu.br/";
        public static final String CONTACT_EMAIL = "fubica@computacao.ufcg.edu.br";
        public static final String API_TITLE = "Computação@UFCG Alumni Service API";
        public static final String API_DESCRIPTION = "This API allows management of information about Computação@UFCG alumni.";
    }

    public static class Model {
        public static final String ALUMNI = "[\n" +
                "    \"alumnus1\",\n" +
                "    \"alumnus2\"\n" +
                "  ]\n";
        public static final String ALUMNUS_NAME = "John Smith";
        public static final String CURRENT_JOB = "John Smith & Sons";
        public static final String START_YEAR = "2000";
        public static final String REGISTRATION = "\"100110007\"";
        public static final String LINKEDIN_ID = "https://www.linkedin.com/in/joaosilva";
        public static final String PUBLICKEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA2uLMdBAGXUCZIHDf1NSs" +
                "Qvh9r72noQEMHQXw+lbKYuxxVzoMKjfa0qXPDvWIQ4E5wJO/VskhBNRZQsWbHPqk" +
                "MFzKlonzu+7KNzyF7Dd0E0KBGfzNWTSeaPXvpUgG7uRULn206mmgOTRWeG+HXbzF" +
                "jtpOVif3F0w+yQsQ2nSFVPTXXdX7pEAbDIMdH0I+Nb3y1Yl5ZJsO+rZcIUK0td7k" +
                "xM+BnKyQTyLkWIocwiw6WXHLOrwEKYDzv35uSha8+iB68kXbehWJxD7mG//WdVzW" +
                "3Rf7gmkApzPbOkeMoKOZJOS7DNkeOl150WbilLURQ7gHH6EiyDqskIlyRYiW6FDF" +
                "+wIDAQAB";
        public static final String FULL_NAME = "Maria da Silva";
    }

    public static class Alumni {
        public static final String API = "Queries information about the alumni.";
        public static final String GET_OPERATION = "Lists information about the alumni.";
        public static final String GET_NAMES_OPERATION = "Lists the names of the alumni.";
        public static final String GET_CURRENT_JOB_OPERATION = "Lists names and current position of alumni.";

    }

    public static class Match {
        public static final String API = "Manages matches between alumni and linkedin profiles.";
        public static final String GET_MATCHES_OPERATION = "Lists matches between alumni and linkedin alumnus";
        public static final String GET_PENDING_MATCHES_OPERATION = "Lists alumni pending matches.";
        public static final String SET_MATCH_OPERATION = "Sets an alumnus match.";
        public static final String RESET_MATCH_OPERATION = "Resets an alumnus match.";
        public static final String REGISTRATION_PARAMETER = "Alumnus registration.";
        public static final String MATCH_PARAMETER = "A registrations number and its matching LinkedIn ID.";
        public static final String PAGE = "The list is paged. This parameter indicates which page should be fetched.";
        public static final String GET_ALUMNUS_MATCHES_OPERATION = "lists matches of one alumnus";
    }

    public static class Version {
        public static final String API = "Queries the version of the service's API.";
        public static final String GET_OPERATION = "Returns the version of the service's API.";
    }

    public class Token {
        public static final String AUTHENTICATION_TOKEN = "Authentication token.";
    }

    public static class PublicKey {
        public static final String API = "Queries the public key of the service.";
        public static final String GET_OPERATION = "Returns the public key of the service.";
    }

    public static class Employers {
        public static final String GET_EMPLOYER_OPERATION = "Lists information from organizations where graduates of a course work or have worked";
        public static final String GET_EMPLOYER_BY_TYPE_OPERATION = "Lists information from organizations of a type where graduates of a course work or have worked";
        public static final String SET_EMPLOYER_TYPE = "Assign type to the organization whose linkedinId is 'linkedinId'";
        public static final String GET_EMPLOYERS_UNDEFINED = "Lists information about organizations where graduates of a course work or have worked, whose type is undefined";
        public static final String DELETE_EMPLOYER_TYPE = "Sets employer type to undefined";
    }

    public static class Statistics {
        public static final String GET_STATISTICS_OPERATION = "returns a Statistic response associated with graduates of the course";
    }
}
