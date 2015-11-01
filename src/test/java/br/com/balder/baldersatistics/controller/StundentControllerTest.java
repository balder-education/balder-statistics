/*package br.com.balder.baldersatistics.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.method.annotation.ExceptionHandlerMethodResolver;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod;

import br.com.balder.baldersatistics.util.StringTestUtil;
import br.com.balder.baldersatistics.util.WebTestUtil;
import br.com.baldereducation.baldersatistics.BalderStatisticsAppConfig;
import br.com.baldereducation.baldersatistics.controller.StundentController;
import br.com.baldereducation.baldersatistics.error.RestErrorHandler;
import br.com.baldereducation.baldersatistics.exception.StudentNotFoundException;
import br.com.baldereducation.baldersatistics.model.domain.to.StundentDTO;
import br.com.baldereducation.baldersatistics.service.StudentService;

*//**
 * @author Rogério Fontes
 *//*
@RunWith(MockitoJUnitRunner.class)
@SpringApplicationConfiguration(classes = BalderStatisticsAppConfig.class)
public class StundentControllerTest {

    private static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    private static final String DESCRIPTION = "description";
    private static final String ID = "id";
    private static final String TITLE = "title";

    private static final int MAX_LENGTH_DESCRIPTION = 500;
    private static final int MAX_LENGTH_TITLE = 100;

    @Mock
    private StudentService service;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new StundentController(service))
                .setHandlerExceptionResolvers(withExceptionControllerAdvice()).build();
    }

    *//**
     * For some reason this does not work. The correct error handler method is
     * invoked but when it tries to return the validation errors as json, the
     * following error appears to log:
     *
     * Failed to invoke @ExceptionHandler method: public
     * com.javaadvent.bootrest.error.ValidationErrorDTO
     * com.javaadvent.bootrest.error.RestErrorHandler.processValidationError(org
     * .springframework.web.bind.MethodArgumentNotValidException)
     * org.springframework.web.HttpMediaTypeNotAcceptableException: Could not
     * find acceptable representation
     *
     * I have to figure out how to fix this before I can write the unit tests
     * that ensure that validation is working.
     *//*
    private ExceptionHandlerExceptionResolver withExceptionControllerAdvice() {
        final ExceptionHandlerExceptionResolver exceptionResolver = new ExceptionHandlerExceptionResolver() {
            @Override
            protected ServletInvocableHandlerMethod getExceptionHandlerMethod(final HandlerMethod handlerMethod,
                    final Exception exception) {
                Method method = new ExceptionHandlerMethodResolver(RestErrorHandler.class).resolveMethod(exception);
                if (method != null) {
                    ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
                    messageSource.setBasename("messages");
                    return new ServletInvocableHandlerMethod(new RestErrorHandler(messageSource), method);
                }
                return super.getExceptionHandlerMethod(handlerMethod, exception);
            }
        };
        exceptionResolver.afterPropertiesSet();
        return exceptionResolver;
    }

    @Test
    public void create_StundentEntryWithOnlyTitle_ShouldCreateNewStundentEntryWithoutDescription() throws Exception {
        StundentDTO newStundentEntry = new StundentDTOBuilder().title(TITLE).build();

        mockMvc.perform(post("/api/stundent").contentType(APPLICATION_JSON_UTF8)
                .content(WebTestUtil.convertObjectToJsonBytes(newStundentEntry)));

        ArgumentCaptor<StundentDTO> createdArgument = ArgumentCaptor.forClass(StundentDTO.class);
        verify(service, times(1)).create(createdArgument.capture());
        verifyNoMoreInteractions(service);

        StundentDTO created = createdArgument.getValue();
        StundentDTOAssert.assertThatStundentDTO(created).hasNoId().hasTitle(TITLE).hasNoDescription();
    }

    @Test
    public void create_StundentEntryWithOnlyTitle_ShouldReturnResponseStatusCreated() throws Exception {
        StundentDTO newStundentEntry = new StundentDTOBuilder().title(TITLE).build();

        when(service.create(isA(StundentDTO.class))).then(invocationOnMock -> {
            StundentDTO saved = (StundentDTO) invocationOnMock.getArguments()[0];
            saved.setId(ID);
            return saved;
        });

        mockMvc.perform(post("/api/stundent").contentType(APPLICATION_JSON_UTF8)
                .content(WebTestUtil.convertObjectToJsonBytes(newStundentEntry))).andExpect(status().isCreated());
    }

    @Test
    public void create_StundentEntryWithOnlyTitle_ShouldReturnTheInformationOfCreatedStundentEntryAsJSon()
            throws Exception {
        StundentDTO newStundentEntry = new StundentDTOBuilder().title(TITLE).build();

        when(service.create(isA(StundentDTO.class))).then(invocationOnMock -> {
            StundentDTO saved = (StundentDTO) invocationOnMock.getArguments()[0];
            saved.setId(ID);
            return saved;
        });

        mockMvc.perform(post("/api/stundent").contentType(APPLICATION_JSON_UTF8)
                .content(WebTestUtil.convertObjectToJsonBytes(newStundentEntry)))
                .andExpect(content().contentType(APPLICATION_JSON_UTF8)).andExpect(jsonPath("$.id", is(ID)))
                .andExpect(jsonPath("$.title", is(TITLE))).andExpect(jsonPath("$.description", isEmptyOrNullString()));
    }

    @Test
    public void create_StundentEntryWithMaxLengthTitleAndDescription_ShouldCreateNewStundentEntryWithCorrectInformation()
            throws Exception {
        String maxLengthTitle = StringTestUtil.createStringWithLength(MAX_LENGTH_TITLE);
        String maxLengthDescription = StringTestUtil.createStringWithLength(MAX_LENGTH_DESCRIPTION);

        StundentDTO newStundentEntry = new StundentDTOBuilder().title(maxLengthTitle).description(maxLengthDescription)
                .build();

        mockMvc.perform(post("/api/stundent").contentType(APPLICATION_JSON_UTF8)
                .content(WebTestUtil.convertObjectToJsonBytes(newStundentEntry)));

        ArgumentCaptor<StundentDTO> createdArgument = ArgumentCaptor.forClass(StundentDTO.class);
        verify(service, times(1)).create(createdArgument.capture());
        verifyNoMoreInteractions(service);

        StundentDTO created = createdArgument.getValue();
        StundentDTOAssert.assertThatStundentDTO(created).hasNoId().hasTitle(maxLengthTitle)
                .hasDescription(maxLengthDescription);
    }

    @Test
    public void create_StundentEntryWithMaxLengthTitleAndDescription_ShouldReturnResponseStatusCreated()
            throws Exception {
        String maxLengthTitle = StringTestUtil.createStringWithLength(MAX_LENGTH_TITLE);
        String maxLengthDescription = StringTestUtil.createStringWithLength(MAX_LENGTH_DESCRIPTION);

        StundentDTO newStundentEntry = new StundentDTOBuilder().title(maxLengthTitle).description(maxLengthDescription)
                .build();

        when(service.create(isA(StundentDTO.class))).then(invocationOnMock -> {
            StundentDTO saved = (StundentDTO) invocationOnMock.getArguments()[0];
            saved.setId(ID);
            return saved;
        });

        mockMvc.perform(post("/api/stundent").contentType(APPLICATION_JSON_UTF8)
                .content(WebTestUtil.convertObjectToJsonBytes(newStundentEntry))).andExpect(status().isCreated());
    }

    @Test
    public void create_StundentEntryWithMaxLengthTitleAndDescription_ShouldReturnTheInformationOfCreatedStundentEntryAsJson()
            throws Exception {
        String maxLengthTitle = StringTestUtil.createStringWithLength(MAX_LENGTH_TITLE);
        String maxLengthDescription = StringTestUtil.createStringWithLength(MAX_LENGTH_DESCRIPTION);

        StundentDTO newStundentEntry = new StundentDTOBuilder().title(maxLengthTitle).description(maxLengthDescription)
                .build();

        when(service.create(isA(StundentDTO.class))).then(invocationOnMock -> {
            StundentDTO saved = (StundentDTO) invocationOnMock.getArguments()[0];
            saved.setId(ID);
            return saved;
        });

        mockMvc.perform(post("/api/stundent").contentType(APPLICATION_JSON_UTF8)
                .content(WebTestUtil.convertObjectToJsonBytes(newStundentEntry)))
                .andExpect(content().contentType(APPLICATION_JSON_UTF8)).andExpect(jsonPath("$.id", is(ID)))
                .andExpect(jsonPath("$.title", is(maxLengthTitle)))
                .andExpect(jsonPath("$.description", is(maxLengthDescription)));
    }

    @Test
    public void delete_StundentEntryNotFound_ShouldReturnResponseStatusNotFound() throws Exception {
        when(service.delete(ID)).thenThrow(new StudentNotFoundException(ID));

        mockMvc.perform(delete("/api/stundent/{id}", ID)).andExpect(status().isNotFound());
    }

    @Test
    public void delete_StundentEntryFound_ShouldReturnResponseStatusOk() throws Exception {
        StundentDTO deleted = new StundentDTOBuilder().id(ID).build();

        when(service.delete(ID)).thenReturn(deleted);

        mockMvc.perform(delete("/api/stundent/{id}", ID)).andExpect(status().isOk());
    }

    @Test
    public void delete_StundentEntryFound_ShouldTheInformationOfDeletedStundentEntryAsJson() throws Exception {
        StundentDTO deleted = new StundentDTOBuilder().id(ID).title(TITLE).description(DESCRIPTION).build();

        when(service.delete(ID)).thenReturn(deleted);

        mockMvc.perform(delete("/api/stundent/{id}", ID)).andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id", is(ID))).andExpect(jsonPath("$.title", is(TITLE)))
                .andExpect(jsonPath("$.description", is(DESCRIPTION)));
    }

    @Test
    public void findAll_ShouldReturnResponseStatusOk() throws Exception {
        mockMvc.perform(get("/api/stundent")).andExpect(status().isOk());
    }

    @Test
    public void findAll_OneStundentEntryFound_ShouldReturnListThatContainsOneStundentEntryAsJson() throws Exception {
        StundentDTO found = new StundentDTOBuilder().id(ID).title(TITLE).description(DESCRIPTION).build();

        when(service.findAll()).thenReturn(Arrays.asList(found));

        mockMvc.perform(get("/api/stundent")).andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(1))).andExpect(jsonPath("$[0].id", is(ID)))
                .andExpect(jsonPath("$[0].title", is(TITLE))).andExpect(jsonPath("$[0].description", is(DESCRIPTION)));
    }

    @Test
    public void findById_StundentEntryFound_ShouldReturnResponseStatusOk() throws Exception {
        StundentDTO found = new StundentDTOBuilder().build();

        when(service.findById(ID)).thenReturn(found);

        mockMvc.perform(get("/api/stundent/{id}", ID)).andExpect(status().isOk());
    }

    @Test
    public void findById_StundentEntryFound_ShouldTheInformationOfFoundStundentEntryAsJson() throws Exception {
        StundentDTO found = new StundentDTOBuilder().id(ID).title(TITLE).description(DESCRIPTION).build();

        when(service.findById(ID)).thenReturn(found);

        mockMvc.perform(get("/api/stundent/{id}", ID)).andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id", is(ID))).andExpect(jsonPath("$.title", is(TITLE)))
                .andExpect(jsonPath("$.description", is(DESCRIPTION)));
    }

    @Test
    public void findById_StundentEntryNotFound_ShouldReturnResponseStatusNotFound() throws Exception {
        when(service.findById(ID)).thenThrow(new StudentNotFoundException(ID));

        mockMvc.perform(get("/api/stundent/{id}", ID)).andExpect(status().isNotFound());
    }

    @Test
    public void update_StundentEntryWithOnlyTitle_ShouldUpdateTheInformationOfStundentEntry() throws Exception {
        StundentDTO updatedStundentEntry = new StundentDTOBuilder().id(ID).title(TITLE).build();

        mockMvc.perform(put("/api/stundent/{id}", ID).contentType(APPLICATION_JSON_UTF8)
                .content(WebTestUtil.convertObjectToJsonBytes(updatedStundentEntry)));

        ArgumentCaptor<StundentDTO> updatedArgument = ArgumentCaptor.forClass(StundentDTO.class);
        verify(service, times(1)).update(updatedArgument.capture());
        verifyNoMoreInteractions(service);

        StundentDTO updated = updatedArgument.getValue();
        StundentDTOAssert.assertThatStundentDTO(updated).hasId(ID).hasTitle(TITLE).hasNoDescription();
    }

    @Test
    public void update_StundentEntryWithOnlyTitle_ShouldReturnResponseStatusOk() throws Exception {
        StundentDTO updatedStundentEntry = new StundentDTOBuilder().id(ID).title(TITLE).build();

        when(service.update(isA(StundentDTO.class)))
                .then(invocationOnMock -> (StundentDTO) invocationOnMock.getArguments()[0]);

        mockMvc.perform(put("/api/stundent/{id}", ID).contentType(APPLICATION_JSON_UTF8)
                .content(WebTestUtil.convertObjectToJsonBytes(updatedStundentEntry))).andExpect(status().isOk());
    }

    @Test
    public void update_StundentEntryWithOnlyTitle_ShouldReturnTheInformationOfUpdatedStundentEntryAsJSon()
            throws Exception {
        StundentDTO updatedStundentEntry = new StundentDTOBuilder().id(ID).title(TITLE).build();

        when(service.update(isA(StundentDTO.class)))
                .then(invocationOnMock -> (StundentDTO) invocationOnMock.getArguments()[0]);

        mockMvc.perform(put("/api/stundent/{id}", ID).contentType(APPLICATION_JSON_UTF8)
                .content(WebTestUtil.convertObjectToJsonBytes(updatedStundentEntry)))
                .andExpect(content().contentType(APPLICATION_JSON_UTF8)).andExpect(jsonPath("$.id", is(ID)))
                .andExpect(jsonPath("$.title", is(TITLE))).andExpect(jsonPath("$.description", isEmptyOrNullString()));
    }

    @Test
    public void update_StundentEntryWithMaxLengthTitleAndDescription_ShouldUpdateTheInformationOfStundentEntry()
            throws Exception {
        String maxLengthTitle = StringTestUtil.createStringWithLength(MAX_LENGTH_TITLE);
        String maxLengthDescription = StringTestUtil.createStringWithLength(MAX_LENGTH_DESCRIPTION);

        StundentDTO updatedStundentEntry = new StundentDTOBuilder().id(ID).title(maxLengthTitle)
                .description(maxLengthDescription).build();

        mockMvc.perform(put("/api/stundent/{id}", ID).contentType(APPLICATION_JSON_UTF8)
                .content(WebTestUtil.convertObjectToJsonBytes(updatedStundentEntry)));

        ArgumentCaptor<StundentDTO> updatedArgument = ArgumentCaptor.forClass(StundentDTO.class);
        verify(service, times(1)).update(updatedArgument.capture());
        verifyNoMoreInteractions(service);

        StundentDTO updated = updatedArgument.getValue();
        StundentDTOAssert.assertThatStundentDTO(updated).hasId(ID).hasTitle(maxLengthTitle)
                .hasDescription(maxLengthDescription);
    }

    @Test
    public void update_StundentEntryWithMaxLengthTitleAndDescription_ShouldReturnResponseStatusOk() throws Exception {
        String maxLengthTitle = StringTestUtil.createStringWithLength(MAX_LENGTH_TITLE);
        String maxLengthDescription = StringTestUtil.createStringWithLength(MAX_LENGTH_DESCRIPTION);

        StundentDTO updatedStundentEntry = new StundentDTOBuilder().id(ID).title(maxLengthTitle)
                .description(maxLengthDescription).build();

        when(service.create(isA(StundentDTO.class)))
                .then(invocationOnMock -> (StundentDTO) invocationOnMock.getArguments()[0]);

        mockMvc.perform(put("/api/stundent/{id}", ID).contentType(APPLICATION_JSON_UTF8)
                .content(WebTestUtil.convertObjectToJsonBytes(updatedStundentEntry))).andExpect(status().isOk());
    }

    @Test
    public void update_StundentEntryWithMaxLengthTitleAndDescription_ShouldReturnTheInformationOfCreatedUpdatedStundentEntryAsJson()
            throws Exception {
        String maxLengthTitle = StringTestUtil.createStringWithLength(MAX_LENGTH_TITLE);
        String maxLengthDescription = StringTestUtil.createStringWithLength(MAX_LENGTH_DESCRIPTION);

        StundentDTO updatedStundentEntry = new StundentDTOBuilder().id(ID).title(maxLengthTitle)
                .description(maxLengthDescription).build();

        when(service.update(isA(StundentDTO.class)))
                .then(invocationOnMock -> (StundentDTO) invocationOnMock.getArguments()[0]);

        mockMvc.perform(put("/api/stundent/{id}", ID).contentType(APPLICATION_JSON_UTF8)
                .content(WebTestUtil.convertObjectToJsonBytes(updatedStundentEntry)))
                .andExpect(content().contentType(APPLICATION_JSON_UTF8)).andExpect(jsonPath("$.id", is(ID)))
                .andExpect(jsonPath("$.title", is(maxLengthTitle)))
                .andExpect(jsonPath("$.description", is(maxLengthDescription)));
    }
}
*/