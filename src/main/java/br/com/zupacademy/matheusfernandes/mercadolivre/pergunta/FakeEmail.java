package br.com.zupacademy.matheusfernandes.mercadolivre.pergunta;

import org.springframework.stereotype.Component;

@Component
public class FakeEmail implements Mailer{

	@Override
	public void send(String body, String subject, String nameFrom, String from,
			String to) {
		System.out.println(body);
		System.out.println(subject);
		System.out.println(nameFrom);
		System.out.println(from);
		System.out.println(to);
	}
}
