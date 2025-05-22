package web.service;

import org.junit.Assert;
import org.junit.Test;

public class TestMathQuestionService {

	@Test
	public void testValidAddition() {
		Assert.assertEquals(3.0, MathQuestionService.q1Addition("1", "2"), 0.001);
	}

	@Test
	public void testValidSubtraction() {
		Assert.assertEquals(1.0, MathQuestionService.q2Subtraction("3", "2"), 0.001);
	}

	@Test
	public void testAdditionEmptyInput() {
		Assert.assertNull(MathQuestionService.q1Addition("", "2"));
		Assert.assertNull(MathQuestionService.q1Addition("2", ""));
	}

	@Test
	public void testSubtractionNullInput() {
		Assert.assertNull(MathQuestionService.q2Subtraction(null, "5"));
		Assert.assertNull(MathQuestionService.q2Subtraction("5", null));
	}

	@Test
	public void testAdditionInvalidNumbers() {
		Assert.assertNull(MathQuestionService.q1Addition("abc", "2"));
		Assert.assertNull(MathQuestionService.q1Addition("2", "xyz"));
	}
}