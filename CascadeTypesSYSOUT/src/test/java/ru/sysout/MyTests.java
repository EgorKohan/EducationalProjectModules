package ru.sysout;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.sysout.models.Comment;
import ru.sysout.models.Topic;
import ru.sysout.repositories.TopicRepository;

import java.util.Arrays;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class MyTests {

    @Autowired
    private TopicRepository topicRepository;

    private static Topic createATopicWithComments() {
        Topic topic = new Topic("topic1");
        Comment comment = new Comment("comment1");
        Comment comment1 = new Comment("comment2");
        topic.getComments().addAll(Arrays.asList(comment, comment1));
        comment.setTopic(topic);
        comment1.setTopic(topic);
        return topic;
    }

    @Test
    void test1() {
        Topic save = topicRepository.save(createATopicWithComments());
        topicRepository.deleteById(save.getId());
    }

}
