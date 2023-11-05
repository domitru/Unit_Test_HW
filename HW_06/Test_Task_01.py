"""Тестирование программы."""
import pytest

from Task_01 import NumsLists


@pytest.fixture(name='list1')
def fixture_list1():
    """
    Фикстура (https://habr.com/ru/articles/731296/),
    возвращающая список со значениями [1, 2, 3, 4, 5].
    """
    return [1, 2, 3, 4, 5]


@pytest.fixture(name='list2')
def fixture_list2():
    """Аналогично."""
    return [2, 3, 4, 5, 6]


def test_init(list1, list2):
    """Проверка корректной инициализации класса."""
    nums_list = NumsLists(list1, list2)
    assert nums_list.lst1 == list1
    assert nums_list.lst2 == list2


def test_get_lists_averages(list1, list2):
    """Проверка средних значений списков размером больше 1."""
    nums_list = NumsLists(list1, list2)
    assert nums_list.get_lists_averages() == (3, 4)


@pytest.mark.parametrize('lst1, lst2, result', [([1, 2, 3], [], (2, 0)),
                                                ([], [1, 2, 3], (0, 2)), ([], [], (0, 0))])
def test_get_empty_lists_averages(lst1, lst2, result):
    """Проверка средних значений, если один или оба списка пустые."""
    nums_list = NumsLists(lst1, lst2)
    assert nums_list.get_lists_averages() == result


@pytest.mark.parametrize('lst1, lst2, result', [([1, 2, 3], [5], (2, 5)),
                                                ([5], [1, 2, 3], (5, 2)), ([5], [5], (5, 5))])
def test_get_one_elemented_lists_averages(lst1, lst2, result):
    """Проверка средних значений, если один или оба списка имеют только один элемент."""
    nums_list = NumsLists(lst1, lst2)
    assert nums_list.get_lists_averages() == result


def test_first_average_more(list1, list2, capfd):
    """Проверка сообщения когда среднее значение первого списка больше второго."""
    nums_list = NumsLists(list2, list1)
    nums_list.compare_averages()
    captured = capfd.readouterr()
    assert captured.out.strip() == 'Первый список имеет большее среднее значение.'


def test_second_average_more(list1, list2, capfd):
    """Проверка сообщения когда среднее значение второго списка больше первого."""
    nums_list = NumsLists(list1, list2)
    nums_list.compare_averages()
    captured = capfd.readouterr()
    assert captured.out.strip() == 'Второй список имеет большее среднее значение.'


def test_equal_averages(list1, capfd):
    """Проверка сообщения когда средние значения списков равны."""
    nums_list = NumsLists(list1, list1)
    nums_list.compare_averages()
    captured = capfd.readouterr()
    assert captured.out.strip() == 'Средние значения равны.'
