package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

// NsTest 우테코에서 콘솔값을 가짜로 넣어주는 기능을 제공
class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
	@DisplayName("1: 기능 테스트")
    void test1() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
	@DisplayName("2: 예외 테스트")
    void test2() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("자동차 이름은 5자 이하여야 합니다")
        );
    }

    @Override
	@DisplayName("3: NsTest 가짜 콘솔입력을 제공")
    public void runMain() {
        Application.main(new String[]{});
    }
}
