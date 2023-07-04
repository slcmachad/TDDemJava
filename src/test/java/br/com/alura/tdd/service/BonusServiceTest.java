package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	@Test
	void bonusZero() {
		BonusService service = new BonusService();
//		assertThrows(IllegalArgumentException.class,
//				() -> service.calcularBonus(new Funcionario("jão", LocalDate.now(), new BigDecimal("25000"))));

		try {
			service.calcularBonus(new Funcionario("jão", LocalDate.now(), new BigDecimal("25000")));
			fail("Não houve a exception");
		} catch (Exception e) {
			assertEquals("Funcionário com salário maior que 10 mil reais não pode receber bônus", e.getMessage());
		}
		
	}
	@Test
	void bonusDeveriaSerDezPorCento() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("jão", LocalDate.now(), new BigDecimal("2500")));
		
		assertEquals(new BigDecimal("250.00"), bonus);
	}
	@Test
	void bonusDeveriaSerDezPorCentoParaSalarioDeDezMil() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("jão", LocalDate.now(), new BigDecimal("10000")));
		
		assertEquals(new BigDecimal("1000.00"), bonus);
	}

}
