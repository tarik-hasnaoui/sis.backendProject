package nl.hva.sisspringboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "exam_registration_line_item")
public class ExamRegistrationLineItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
        
        @OneToOne(mappedBy = "examRegistrationLineItem")
	private ExamRegistration examRegistration;
        
        @JsonIgnore
        @ManyToOne(cascade = CascadeType.ALL)
        private ExamRegistrationBasket examRegistrationBasket;

	public ExamRegistrationLineItem(ExamRegistration examRegistration) {
		this.examRegistration = examRegistration;
	}

	public ExamRegistrationLineItem() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ExamRegistration getExam() {
		return examRegistration;
	}

	public void setExam(ExamRegistration examRegistration) {
		this.examRegistration = examRegistration;
	}

}
