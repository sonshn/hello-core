package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    // new()의 인자로 TestBean.class를 넣어주면 TestBean도 스프링 빈에 등록이 된다.
    static class TestBean{

        @Autowired(required = false)
        public void setNoBean1(Member member){
            System.out.println("setNoBean1 = " + member);
        }

        @Autowired
        public void setNoBean2(@Nullable Member member){
            System.out.println("setNoBean2 = " + member);
        }

        @Autowired(required = false)
        public void setNoBean3(Optional<Member> member){
            System.out.println("setNoBean3 = " + member);
        }
    }
}
