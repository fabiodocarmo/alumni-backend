package br.edu.ufcg.computacao.alumni.api.http.request;

import br.edu.ufcg.computacao.alumni.api.http.CommonKeys;
import br.edu.ufcg.computacao.alumni.api.http.response.EmployerResponse;
import br.edu.ufcg.computacao.alumni.constants.ApiDocumentation;
import br.edu.ufcg.computacao.alumni.constants.Messages;
import br.edu.ufcg.computacao.alumni.constants.SystemConstants;
import br.edu.ufcg.computacao.alumni.core.ApplicationFacade;
import br.edu.ufcg.computacao.alumni.core.models.EmployerType;
import br.edu.ufcg.computacao.eureca.common.exceptions.EurecaException;
import br.edu.ufcg.computacao.eureca.common.exceptions.InvalidParameterException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = Linkedin.ENDPOINT)
@Api(description = ApiDocumentation.Alumni.API)
public class Employer {
    protected static final String ENDPOINT = SystemConstants.SERVICE_BASE_ENDPOINT + "employer";

    private static final Logger LOGGER = Logger.getLogger(Employer.class);

    @RequestMapping(value = "/{page}", method = RequestMethod.GET)
    @ApiOperation(value = ApiDocumentation.Employers.GET_EMPLOYER_OPERATION)
    public ResponseEntity<Page<EmployerResponse>> getEmployers(
            @ApiParam(value = ApiDocumentation.Token.AUTHENTICATION_TOKEN)
            @PathVariable String page,
            @RequestHeader(required = true, value = CommonKeys.AUTHENTICATION_TOKEN_KEY) String token)
            throws EurecaException {
        try {
            int p;
            try{
                p = Integer.parseInt(page);
            } catch(NumberFormatException e) {
                throw new InvalidParameterException(Messages.PAGE_MUST_BE_AN_INTEGER);
            }

            Page<EmployerResponse> employers = ApplicationFacade.getInstance().getEmployers(token, p);
            return new ResponseEntity(employers, HttpStatus.OK);
        } catch(EurecaException e) {
            LOGGER.info(String.format(Messages.SOMETHING_WENT_WRONG, e.getMessage()), e);
            throw e;
        }

    }

    @RequestMapping(value = "/{type}/{page}", method = RequestMethod.GET)
    @ApiOperation(value = ApiDocumentation.Employers.GET_EMPLOYER_BY_TYPE_OPERATION)
    public ResponseEntity<Page<EmployerResponse>> getEmployersByType(
            @ApiParam(value = ApiDocumentation.Token.AUTHENTICATION_TOKEN)
            @PathVariable String page,
            @PathVariable String type,
            @RequestHeader(required = true, value = CommonKeys.AUTHENTICATION_TOKEN_KEY) String token)
            throws EurecaException {

        try {
            int p;
            EmployerType t;
            try{
                p = Integer.parseInt(page);
                t =  EmployerType.valueOf(type);
            } catch(NumberFormatException e) {
                throw new InvalidParameterException(Messages.PAGE_MUST_BE_AN_INTEGER);

            } catch(IllegalArgumentException e) {
                throw new InvalidParameterException(Messages.TYPE_MUST_BE_AN_EMPLOYER_TYPE);
            }

            Page<EmployerResponse> employers = ApplicationFacade.getInstance().getEmployersByType(token, p, t);
            return new ResponseEntity(employers, HttpStatus.OK);
        } catch(EurecaException e) {
            LOGGER.info(String.format(Messages.SOMETHING_WENT_WRONG, e.getMessage()), e);
            throw e;
        }

    }

    @RequestMapping(value = "/undefined/{page}", method = RequestMethod.GET)
    @ApiOperation(value = ApiDocumentation.Employers.GET_EMPLOYERS_UNDEFINED)
    public ResponseEntity<Void> getEmployersUndefined(
            @ApiParam(value = ApiDocumentation.Token.AUTHENTICATION_TOKEN)
            @PathVariable String page,
            @RequestHeader(required = true, value = CommonKeys.AUTHENTICATION_TOKEN_KEY) String token)
            throws EurecaException {

            try {
                int p;
                try{
                    p = Integer.parseInt(page);
                }catch(NumberFormatException e) {
                    throw new InvalidParameterException(Messages.PAGE_MUST_BE_AN_INTEGER);
                }
                Page<EmployerResponse> employers = ApplicationFacade.getInstance().getEmployersUndefined(token, p);
                return new ResponseEntity(employers, HttpStatus.OK);

            } catch (EurecaException e) {
                LOGGER.info(String.format(Messages.SOMETHING_WENT_WRONG, e.getMessage()), e);
                throw e;
            }
    }

    @RequestMapping(value = "/{linkedinId}", method = RequestMethod.DELETE)
    @ApiOperation(value = ApiDocumentation.Employers.DELETE_EMPLOYER_TYPE)
    public ResponseEntity<Void> deleteEmployerType(
            @ApiParam(value = ApiDocumentation.Token.AUTHENTICATION_TOKEN)
            @PathVariable String linkedinId,
            @RequestHeader(required = true, value = CommonKeys.AUTHENTICATION_TOKEN_KEY) String token)
            throws EurecaException {

        try {
            ApplicationFacade.getInstance().setEmployerTypeToUndefined(token, linkedinId);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (EurecaException e) {
            LOGGER.info(String.format(Messages.SOMETHING_WENT_WRONG, e.getMessage()), e);
            throw e;
        }
    }

    @RequestMapping(value = "{type}/{linkedinId}", method = RequestMethod.PUT)
    @ApiOperation(value = ApiDocumentation.Employers.SET_EMPLOYER_TYPE)
    public ResponseEntity<Void> setEmployerType(
            @ApiParam(value = ApiDocumentation.Token.AUTHENTICATION_TOKEN)
            @PathVariable String type,
            @PathVariable String linkedinId,
            @RequestHeader(required = true, value = CommonKeys.AUTHENTICATION_TOKEN_KEY) String token)
            throws EurecaException {

        try {
            EmployerType t;
            try {
                t = EmployerType.valueOf(type);

            } catch (IllegalArgumentException e) {
                throw new InvalidParameterException(Messages.TYPE_MUST_BE_AN_EMPLOYER_TYPE);
            }
            ApplicationFacade.getInstance().setEmployerType(token, t, linkedinId);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (EurecaException e) {
            LOGGER.info(String.format(Messages.SOMETHING_WENT_WRONG, e.getMessage()), e);
            throw e;
        }

    }
}