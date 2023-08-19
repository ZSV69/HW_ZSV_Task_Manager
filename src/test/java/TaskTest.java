import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.support.hierarchical.ThrowableCollector;

public class TaskTest {

    @Test

    public void getId() {
        SimpleTask simpleTask = new SimpleTask(2, "Покормить кота");

        int expected = 2;
        int actual = simpleTask.getId();

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void shouldMatchesInSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(2, "Покормить кота");
        simpleTask.getTitle();

        boolean expected = true;
        boolean actual = simpleTask.matches("Покормить");

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void shouldNotMatchesInSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(2, "Покормить кота");
        simpleTask.getTitle();

        boolean expected = false;
        boolean actual = simpleTask.matches("Погулять");

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void shouldMatchesInEpic() {
        String[] subtasks = {"Вынести мусор", "Сходить в магазин"};
        Epic epic = new Epic(3, subtasks);
        epic.getSubtask();


        boolean expected = true;
        boolean actual = epic.matches("Вынести");

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void shouldNotMatchesInEpic() {
        String[] subtasks = {"Вынести мусор", "Сходить в магазин"};
        Epic epic = new Epic(3, subtasks);
        epic.getSubtask();


        boolean expected = false;
        boolean actual = epic.matches("Убраться");

        Assertions.assertEquals(expected, actual);
    }


    @Test

    public void shouldMatchesInMeetingTopic() {
        Meeting meeting = new Meeting(4, "Посуда", "Кухня", "Сегодня");
        meeting.getTopic();
        meeting.getProject();
        meeting.getStart();


        boolean expected = true;
        boolean actual = meeting.matches("Посуда");

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void shouldNotMatchesInMeetingTopic() {
        Meeting meeting = new Meeting(4, "Посуда", "Кухня", "Сегодня");
        meeting.getTopic();
        meeting.getProject();
        meeting.getStart();


        boolean expected = false;
        boolean actual = meeting.matches("Тарелка");

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void shouldMatchesInMeetingProject() {
        Meeting meeting = new Meeting(4, "Посуда", "Кухня", "Сегодня");


        boolean expected = true;
        boolean actual = meeting.matches("Кухня");

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void shouldNotMatchesInMeetingProject() {
        Meeting meeting = new Meeting(4, "Посуда", "Кухня", "Сегодня");


        boolean expected = false;
        boolean actual = meeting.matches("Гараж");

        Assertions.assertEquals(expected, actual);
    }
}
