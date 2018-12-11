package nl.hva.sisspringboot.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "exam_registration_basket")
public class ExamRegistrationBasket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToMany(mappedBy = "examRegistrationBasket")
	private List<ExamRegistrationLineItem> examRegistrationLineItems;

	public ExamRegistrationBasket() {
	}

	public ExamRegistrationBasket(List<ExamRegistrationLineItem> examRegistrationLineItems) {
		this.examRegistrationLineItems = examRegistrationLineItems;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ExamRegistrationLineItem> getExamRegistrationLineItems() {
		return examRegistrationLineItems;
	}

	public void setExamRegistrationLineItems(List<ExamRegistrationLineItem> examRegistrationLineItems) {
		this.examRegistrationLineItems = examRegistrationLineItems;
	}

}
