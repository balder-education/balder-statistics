/*package br.com.balder.baldersatistics.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import br.com.balder.baldersatistics.model.domain.StudentAssert;
import br.com.balder.baldersatistics.model.domain.StudentDTOAssert;
import br.com.balder.baldersatistics.model.domain.StudentDTOBuilder;
import br.com.baldereducation.baldersatistics.exception.StudentNotFoundException;
import br.com.baldereducation.baldersatistics.model.domain.Student;
import br.com.baldereducation.baldersatistics.model.domain.Student.StudentBuilder;
import br.com.baldereducation.baldersatistics.model.domain.to.StundentDTO;
import br.com.baldereducation.baldersatistics.model.repository.StudentRepository;
import br.com.baldereducation.baldersatistics.service.StudentService;

*//**
 * @author Rogério Fontes
 *//*
@RunWith(MockitoJUnitRunner.class)

public class TodoServiceTest {

    private static final String DESCRIPTION = "description";
    private static final String ID = "id";
    private static final String TITLE = "title";

    @Mock
    private StudentRepository repository;

    private StudentService service;

    @Before
    public void setUp() {

    }

    @Test
    @Ignore
    public void create_ShouldSaveNewTodoEntry() {
        StundentDTO newTodo = new StudentDTOBuilder().title(TITLE).description(DESCRIPTION).build();

        when(repository.save(isA(Student.class))).thenAnswer(invocation -> (Student) invocation.getArguments()[0]);

        service.create(newTodo);

        ArgumentCaptor<Student> savedTodoArgument = ArgumentCaptor.forClass(Student.class);

        verify(repository, times(1)).save(savedTodoArgument.capture());
        verifyNoMoreInteractions(repository);

        Student savedTodo = savedTodoArgument.getValue();
        StudentAssert.assertThatTodo(savedTodo).hasTitle(TITLE).hasDescription(DESCRIPTION);
    }

    @Test
    @Ignore
    public void create_ShouldReturnTheInformationOfCreatedTodoEntry() {
        StundentDTO newTodo = new StudentDTOBuilder().title(TITLE).description(DESCRIPTION).build();

        when(repository.save(isA(Student.class))).thenAnswer(invocation -> {
            Student persisted = (Student) invocation.getArguments()[0];
            ReflectionTestUtils.setField(persisted, "id", ID);
            return persisted;
        });

        StundentDTO returned = service.create(newTodo);

        StudentDTOAssert.assertThatTodoDTO(returned).hasId(ID).hasTitle(TITLE).hasDescription(DESCRIPTION);
    }

    @Test(expected = StudentNotFoundException.class)
    @Ignore
    public void delete_TodoEntryNotFound_ShouldThrowException() {
        when(repository.findOne(ID)).thenReturn(Optional.empty());

        service.findById(ID);
    }

    @Test
    @Ignore
    public void delete_TodoEntryFound_ShouldDeleteTheFoundTodoEntry() {
        Student deleted = new StudentBuilder().id(ID).build();

        when(repository.findOne(ID)).thenReturn(Optional.of(deleted));

        service.delete(ID);

        verify(repository, times(1)).delete(deleted);
    }

    @Test
    @Ignore
    public void delete_TodoEntryFound_ShouldReturnTheDeletedTodoEntry() {
        Student deleted = new StudentBuilder().id(ID).title(TITLE).description(DESCRIPTION).build();

        when(repository.findOne(ID)).thenReturn(Optional.of(deleted));

        StundentDTO returned = service.delete(ID);

        StudentDTOAssert.assertThatTodoDTO(returned).hasId(ID).hasTitle(TITLE).hasDescription(DESCRIPTION);
    }

    @Test
    @Ignore
    public void findAll_OneTodoEntryFound_ShouldReturnTheInformationOfFoundTodoEntry() {
        Student expected = new StudentBuilder().id(ID).title(TITLE).description(DESCRIPTION).build();

        when(repository.findAll()).thenReturn(Arrays.asList(expected));

        List<StundentDTO> todoEntries = service.findAll();
        assertThat(todoEntries).hasSize(1);

        StundentDTO actual = todoEntries.iterator().next();
        StudentDTOAssert.assertThatTodoDTO(actual).hasId(ID).hasTitle(TITLE).hasDescription(DESCRIPTION);
    }

    @Test(expected = StudentNotFoundException.class)
    @Ignore
    public void findById_TodoEntryNotFound_ShouldThrowException() {
        when(repository.findOne(ID)).thenReturn(Optional.empty());

        service.findById(ID);
    }

    @Test
    @Ignore
    public void findById_TodoEntryFound_ShouldReturnTheInformationOfFoundTodoEntry() {
        Student found = new StudentBuilder().id(ID).title(TITLE).description(DESCRIPTION).build();

        when(repository.findOne(ID)).thenReturn(Optional.of(found));

        StundentDTO returned = service.findById(ID);

        StudentDTOAssert.assertThatTodoDTO(returned).hasId(ID).hasTitle(TITLE).hasDescription(DESCRIPTION);
    }

    @Test(expected = StudentNotFoundException.class)
    @Ignore
    public void update_UpdatedTodoEntryNotFound_ShouldThrowException() {
        when(repository.findOne(ID)).thenReturn(Optional.empty());

        StundentDTO updated = new StudentDTOBuilder().id(ID).build();

        service.update(updated);
    }

    @Test
    @Ignore
    public void update_UpdatedTodoEntryFound_ShouldSaveUpdatedTodoEntry() {
        Student existing = new StudentBuilder().id(ID).build();

        when(repository.findOne(ID)).thenReturn(Optional.of(existing));
        when(repository.save(existing)).thenReturn(existing);

        StundentDTO updated = new StudentDTOBuilder().id(ID).title(TITLE).description(DESCRIPTION).build();

        service.update(updated);

        verify(repository, times(1)).save(existing);
        // TodoDTOAssert.assertThatTodo(existing).hasId(ID).hasTitle(TITLE).hasDescription(DESCRIPTION);
    }

    @Test
    @Ignore
    public void update_UpdatedTodoEntryFound_ShouldReturnTheInformationOfUpdatedTodoEntry() {
        Student existing = new StudentBuilder().id(ID).build();

        when(repository.findOne(ID)).thenReturn(Optional.of(existing));
        when(repository.save(existing)).thenReturn(existing);

        StundentDTO updated = new StudentDTOBuilder().id(ID).title(TITLE).description(DESCRIPTION).build();

        StundentDTO returned = service.update(updated);
        StudentDTOAssert.assertThatTodoDTO(returned).hasId(ID).hasTitle(TITLE).hasDescription(DESCRIPTION);
    }
}
*/