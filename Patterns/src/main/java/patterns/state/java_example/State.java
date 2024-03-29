package patterns.state.java_example;

import lombok.Getter;
import lombok.Setter;

/**
 * Состояние — это поведенческий паттерн проектирования,
 * который позволяет объектам менять поведение в зависимости от своего состояния.
 * Извне создаётся впечатление, что изменился класс объекта.
 * <b>Проблема</b><br>
 * Основная идея в том, что программа может находиться в одном из нескольких состояний,
 * которые всё время сменяют друг друга. Набор этих состояний, а также переходов между ними,
 * предопределён и конечен. Находясь в разных состояниях, программа может по-разному реагировать
 * на одни и те же события, которые происходят с ней.
 * <br>
 * Такой подход можно применить и к отдельным объектам. Например, объект Документ может принимать
 * три состояния: Черновик, Модерация или Опубликован. В каждом из этих состоянии метод опубликовать
 * будет работать по-разному:
 * <br>
 * Из черновика он отправит документ на модерацию.
 * Из модерации — в публикацию, но при условии, что это сделал администратор.
 * В опубликованном состоянии метод не будет делать ничего.
 * <img src="https://refactoring.guru/images/patterns/diagrams/state/problem2-ru.png"/>
 * Машину состояний чаще всего реализуют с помощью множества условных операторов, if либо switch,
 * которые проверяют текущее состояние объекта и выполняют соответствующее поведение.
 * Наверняка вы уже реализовали хотя бы одну машину состояний в своей жизни, даже не зная об этом.
 * Как насчёт вот такого кода, выглядит знакомо?
 * <p>
 * class Document is<br>
 * field state: string<br>
 * // ...<br>
 * method publish() is<br>
 * switch (state)<br>
 * "draft":<br>
 * state = "moderation"<br>
 * break<br>
 * "moderation":<br>
 * if (currentUser.role == 'admin')<br>
 * state = "published"<br>
 * break<br>
 * "published":<br>
 * // Do nothing.<br>
 * break<br>
 * // ...<br>
 * Основная проблема такой машины состояний проявится в том случае, если в
 * Документ добавить ещё десяток состояний. Каждый метод будет состоять из увесистого
 * условного оператора, перебирающего доступные состояния. Такой код крайне сложно поддерживать.
 * Малейшее изменение логики переходов заставит вас перепроверять работу всех методов, которые
 * содержат условные операторы машины состояний.
 * <p><br>
 * Путаница и нагромождение условий особенно сильно проявляется в старых проектах.
 * Набор возможных состояний бывает трудно предопределить заранее, поэтому они всё время
 * добавляются в процессе эволюции программы. Из-за этого решение, которое выглядело простым
 * и эффективным в самом начале разработки, может впоследствии стать проекцией большого макаронного монстра.
 * <br>
 * <b>Решение</b>
 * Паттерн Состояние предлагает создать отдельные классы для каждого состояния,
 * в котором может пребывать объект, а затем вынести туда поведения, соответствующие этим состояниям.
 * <p>
 * Вместо того, чтобы хранить код всех состояний, первоначальный объект, называемый контекстом,
 * будет содержать ссылку на один из объектов-состояний и делегировать ему работу, зависящую от состояния.
 * <br>
 * <img src="https://refactoring.guru/images/patterns/diagrams/state/solution-ru.png"/>
 * Благодаря тому, что объекты состояний будут иметь общий интерфейс, контекст сможет
 * делегировать работу состоянию, не привязываясь к его классу. Поведение контекста можно
 * будет изменить в любой момент, подключив к нему другой объект-состояние.
 * <br>
 * <p>
 * Очень важным нюансом, отличающим этот паттерн от Стратегии, является то, что и контекст,
 * и сами конкретные состояния могут знать друг о друге и инициировать переходы от одного состояния к другому.
 * Аналогия из жизни<br>
 * Ваш смартфон ведёт себя по-разному, в зависимости от текущего состояния:<br>
 * <ul>
 * <li>
 * Когда телефон разблокирован, нажатие кнопок телефона приводит к каким-то действиям.
 * </li>
 * <li>
 * Когда телефон заблокирован, нажатие кнопок приводит к экрану разблокировки.
 * </li>
 * <li>
 * Когда телефон разряжен, нажатие кнопок приводит к экрану зарядки.
 * </li>
 * </ul>
 * <b>Структура</b>
 * <ing src="https://refactoring.guru/images/patterns/diagrams/state/structure-ru.png"/>
 * <b>Псевдокод</b>
 * <img src="https://refactoring.guru/images/patterns/diagrams/state/example.png"/>
 */

public abstract class State {

    @Setter @Getter
    protected Player player;

    protected State(Player player) {
        this.player = player;
    }

    public abstract String onLock();
    public abstract String onPlay();
    public abstract String onNext();
    public abstract String onPrevious();

}
