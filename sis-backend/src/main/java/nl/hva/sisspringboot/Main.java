
package nl.hva.sisspringboot;

import java.math.BigInteger;
import java.math.RoundingMode;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import nl.hva.sisspringboot.dao.BlockDao;
import nl.hva.sisspringboot.dao.CourseDao;
import nl.hva.sisspringboot.dao.CourseProgramDao;
import nl.hva.sisspringboot.dao.ExamDao;
import nl.hva.sisspringboot.dao.ExamRegistrationDao;
import nl.hva.sisspringboot.dao.ExamResultDao;
import nl.hva.sisspringboot.dao.GroupDao;
import nl.hva.sisspringboot.dao.ModuleDao;
import nl.hva.sisspringboot.dao.SchoolYearDao;
import nl.hva.sisspringboot.dao.SemesterDao;
import nl.hva.sisspringboot.dao.StudentProfileDao;
import nl.hva.sisspringboot.dao.UserDao;
import nl.hva.sisspringboot.dao.UserRoleDao;
import nl.hva.sisspringboot.model.Block;
import nl.hva.sisspringboot.model.Course;
import nl.hva.sisspringboot.model.CourseGroup;
import nl.hva.sisspringboot.model.CourseProgram;
import nl.hva.sisspringboot.model.CourseType;
import nl.hva.sisspringboot.model.Exam;
import nl.hva.sisspringboot.model.ExamRegistration;
import nl.hva.sisspringboot.model.ExamResult;
import nl.hva.sisspringboot.model.ExamType;
import nl.hva.sisspringboot.model.Module;
import nl.hva.sisspringboot.model.SchoolYear;
import nl.hva.sisspringboot.model.Semester;
import nl.hva.sisspringboot.model.StudentProfile;
import nl.hva.sisspringboot.model.User;
import nl.hva.sisspringboot.model.UserRole;
import nl.hva.sisspringboot.model.UserRoleType;
import nl.hva.sisspringboot.utils.DatabasePopulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private UserDao userDao;

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private ModuleDao moduleDao;

    @Autowired
    private BlockDao blockDao;

    @Autowired
    private SemesterDao semesterDao;

    @Autowired
    private SchoolYearDao schoolYearDao;

    @Autowired
    private StudentProfileDao studentProfileDao;

    @Autowired
    private GroupDao groupDao;

    @Autowired
    private ExamDao examDao;

    @Autowired
    private ExamResultDao examResultDao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Autowired
    private CourseProgramDao courseProgramDao;
    
    @Autowired
    private ExamRegistrationDao examRegistrationDao;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner demo() {
        return (args) -> {
            userRoleDao.save(new UserRole(UserRoleType.ADMIN));
            userRoleDao.save(new UserRole(UserRoleType.STUDENT));
            userRoleDao.save(new UserRole(UserRoleType.TEACHER));

            moduleDao.save(getModules());

            Course ecodu = DatabasePopulator.createCourse("ECODU", "Communicatie", CourseType.PARTTIME, null);
            courseDao.save(ecodu);
            Course dict03 = DatabasePopulator.createCourse("DICT03", "ICT", CourseType.FULLTIME, null);
            courseDao.save(dict03);

            Block block1 = new Block(1, new GregorianCalendar(2015, 7, 31).getTime(), new GregorianCalendar(2015, 9, 29).getTime(), Arrays.asList(moduleDao.findByModuleName("Programming"), moduleDao.findByModuleName("Design & Development UML"),
                    moduleDao.findByModuleName("Design & Development SCRUM"), moduleDao.findByModuleName("Infrastructure")), null);
            Block block2 = new Block(2, new GregorianCalendar(2015, 10, 9).getTime(), new GregorianCalendar(2016, 0, 28).getTime(), Arrays.asList(moduleDao.findByModuleName("Essential Skills"), moduleDao.findByModuleName("Data Modelling & Databases"),
                    moduleDao.findByModuleName("Professional Skills 1.1a"), moduleDao.findByModuleName("Professional Skills 1.1b")), null);
            Block block3 = new Block(3, new GregorianCalendar(2016, 1, 1).getTime(), new GregorianCalendar(2016, 3, 4).getTime(), Arrays.asList(moduleDao.findByModuleName("Databases 2"), moduleDao.findByModuleName("Fasten Your Seatbelts"),
                    moduleDao.findByModuleName("Object Oriented Programming 1"), moduleDao.findByModuleName("Professional Skills 1.2a")), null);
            Block block4 = new Block(4, new GregorianCalendar(2016, 3, 11).getTime(), new GregorianCalendar(2016, 5, 16).getTime(), Arrays.asList(moduleDao.findByModuleName("Testing"), moduleDao.findByModuleName("Object Oriented Programming 2"),
                    moduleDao.findByModuleName("Professional Skills 1.2b")), null);
            blockDao.save(Arrays.asList(block1, block2, block3, block4));

            Semester semester1 = new Semester(1, block1.getStartDate(), block2.getEndDate(),
                    Arrays.asList(block1, block2), null);

            block1.setSemester(semester1);
            block2.setSemester(semester1);

            semesterDao.save(semester1);
            blockDao.save(Arrays.asList(block1, block2));

            Semester semester2 = new Semester(2, block3.getStartDate(), block4.getEndDate(),
                    Arrays.asList(block3, block4), null);

            block3.setSemester(semester2);
            block4.setSemester(semester2);

            semesterDao.save(semester2);
            blockDao.save(Arrays.asList(block3, block4));

            Set<Semester> semesters1 = new HashSet();
            semesters1.add(semester1);
            semesters1.add(semester2);
            SchoolYear schoolyear1 = new SchoolYear(1, semester1.getStartDate(), semester2.getEndDate(), semesters1, null, null);

            schoolYearDao.save(schoolyear1);
            semester1.setSchoolYear(schoolyear1);
            semester2.setSchoolYear(schoolyear1);
            semesterDao.save(Arrays.asList(semester1, semester2));

            Block blockEen = new Block(1, new GregorianCalendar(2016, 8, 5).getTime(), new GregorianCalendar(2016, 01, 3).getTime(), Arrays.asList(moduleDao.findByModuleName("Professional Skills 2.1a"), moduleDao.findByModuleName("Datastructures"),
                    moduleDao.findByModuleName("OOAD"), moduleDao.findByModuleName("Sorting & Searching")), null);
            Block blockTwee = new Block(2, new GregorianCalendar(2016, 10, 14).getTime(), new GregorianCalendar(2017, 0, 26).getTime(), Arrays.asList(moduleDao.findByModuleName("Pr. Enterprise Web Application Techno"), moduleDao.findByModuleName("Pr. Enterprise Web Application Individueel"),
                    moduleDao.findByModuleName("Pr. Enterprise Web Application doc")), null);
            Block blockDrie = new Block(3, new GregorianCalendar(2017, 1, 1).getTime(), new GregorianCalendar(2017, 3, 4).getTime(), Arrays.asList(moduleDao.findByModuleName("Bedrijfspunt (Mob. Developm.)"), moduleDao.findByModuleName("Mobile Application Development"),
                    moduleDao.findByModuleName("Mobile Design & Prototyping")), null);
            Block blockVier = new Block(4, new GregorianCalendar(2017, 3, 11).getTime(), new GregorianCalendar(2017, 5, 16).getTime(), Arrays.asList(moduleDao.findByModuleName("Mobile Infrastructure & Sec."), moduleDao.findByModuleName("Mobile Society"),
                    moduleDao.findByModuleName("Project Mobile Development"), moduleDao.findByModuleName("Professional Skills MobDev.")), null);

            Semester semesterEen = new Semester(1, blockEen.getStartDate(), blockTwee.getEndDate(),
                    Arrays.asList(blockEen, blockTwee), null);

            blockEen.setSemester(semesterEen);
            blockTwee.setSemester(semesterEen);

            semesterDao.save(semesterEen);
            blockDao.save(Arrays.asList(blockEen, blockTwee));

            Semester semesterTwee = new Semester(2, blockDrie.getStartDate(), blockVier.getEndDate(),
                    Arrays.asList(blockDrie, blockVier), null);

            blockDrie.setSemester(semesterTwee);
            blockVier.setSemester(semesterTwee);

            semesterDao.save(semesterTwee);
            blockDao.save(Arrays.asList(blockDrie, blockVier));
            Set<Semester> semesters2 = new HashSet();
            semesters2.add(semesterEen);
            semesters2.add(semesterTwee);

            SchoolYear schoolyear2 = new SchoolYear(2, semesterEen.getStartDate(), semesterTwee.getEndDate(), semesters2, null, null);

            schoolYearDao.save(schoolyear2);
            semesterEen.setSchoolYear(schoolyear2);
            semesterTwee.setSchoolYear(schoolyear2);
            semesterDao.save(Arrays.asList(semesterEen, semesterTwee));

            CourseProgram courseProgram = new CourseProgram(ecodu, Arrays.asList(schoolyear1, schoolyear2));
            courseProgramDao.save(courseProgram);

            schoolyear1.setCourseProgram(courseProgramDao.findOne(1L));
            schoolyear2.setCourseProgram(courseProgramDao.findOne(1L));
            schoolYearDao.save(Arrays.asList(schoolyear1, schoolyear2));

            //create examResults
            //create course groups
            SecureRandom random = new SecureRandom();
            String token = new BigInteger(130, random).toString(32);

            StudentProfile pietProfile = DatabasePopulator.createUserProfile("00050079", new GregorianCalendar(2008, 2, 1).getTime(), new GregorianCalendar(2015, 2, 1).getTime(), "HAVO", null, null, courseProgram, 'V', "P.S", "Piet",
                    "Smit", null, "0612345678", new GregorianCalendar(1963, 4, 9).getTime(), "Edam", null, "Dutch",
                    DatabasePopulator.createAddress("Schoener", 45, "-11", "1135XW", "Edam"));

            User piet = DatabasePopulator.createUser("piet.smit@hva.nl", "1234", token, true, pietProfile,
                    new Date(), userRoleDao.findByUserRoleName(UserRoleType.STUDENT));

            userDao.save(piet);

            token = new BigInteger(130, random).toString(32);
            Course ebidu = DatabasePopulator.createCourse("EBIDU", "Bedrijfskundige Informatica", CourseType.PARTTIME, null);
            courseDao.save(ebidu);

            StudentProfile klaasProfile = DatabasePopulator.createUserProfile("00051874", new GregorianCalendar(1997, 9, 1).getTime(), new GregorianCalendar(2000, 9, 30).getTime(), "HO", null, null, courseProgram, 'V', "P.S", "Klaas",
                    "VandeOverkant", null, "0652647891", new GregorianCalendar(1967, 6, 6).getTime(), "Amsterdam", null, "Dutch",
                    DatabasePopulator.createAddress("Hogegraafe", 3, null, "1095JP", "Amsterdam"));

            User klaas = DatabasePopulator.createUser("klaas.vandeoverkantt@hva.nl", "1234", token, true, klaasProfile,
                    new Date(), userRoleDao.findByUserRoleName(UserRoleType.STUDENT));

            userDao.save(klaas);
//
//			token = new BigInteger(130, random).toString(32);
//			Location haarlem = DatabasePopulator.createLocation("Haarlem", "Netherlands");
//			Location smallingerland = DatabasePopulator.createLocation("Smallingerland", "Netherlands");
//			UserProfile fatimaProfile = DatabasePopulator.createUserProfile("00052466", 'M', "F.H", "Fatima",
//					  "Heilbron", null, "0689743256", new GregorianCalendar(1964, 12, 15).getTime(), smallingerland, null, "Dutch",
//					  new GregorianCalendar(2006, 9, 1).getTime(), new GregorianCalendar(2008, 8, 31).getTime(),
//					  DatabasePopulator.createAddress("Fernicha", 2, "a", "2011DH", haarlem),
//					  Arrays.asList(ebidu),
//					  "HO");
//			fatimaProfile.getCourse().get(0).setUserProfiles(Arrays.asList(fatimaProfile));
//			User fatima = DatabasePopulator.createUser("fatima.heilbron@hva.nl", "1234", token, true, fatimaProfile,
//					  new Date(), new UserRole(UserRoleType.STUDENT));
//
//			userDao.save(fatima);
//
//			facultyDao.save(new Faculty("hva", locationDao.findByCity(haarlem.getCity()), courseDao.findAll()));
//
            populateGroup(pietProfile, klaasProfile/*, fatimaProfile*/);
            populateExam(pietProfile, klaasProfile/*, fatimaProfile*/);
        };
    }

    private List<Module> getModules() {
        List<Module> modules = new ArrayList();
        //Semester 1
        modules.add(new Module("Business", 3));
        modules.add(new Module("Design & Development UML", 2));
        modules.add(new Module("Design & Development SCRUM", 2));
        modules.add(new Module("User Interaction", 2));
        modules.add(new Module("Data Modelling & Databases", 3));
        modules.add(new Module("Essential Skills", 4));
        modules.add(new Module("Infrastructure", 3));
        modules.add(new Module("Programming", 3));
        modules.add(new Module("Professional Skills 1.1a", 3));
        modules.add(new Module("Professional Skills 1.1b", 5));
        modules.add(new Module("Professional Skills 1.2a", 4));
        modules.add(new Module("Professional Skills 1.2b", 2));

        //Semester 2
        modules.add(new Module("Databases 2", 3));
        modules.add(new Module("Fasten Your Seatbelts", 12));
        modules.add(new Module("Object Oriented Programming 1", 3));
        modules.add(new Module("Object Oriented Programming 2", 3));
        modules.add(new Module("Testing", 3));

        //Semester 3
        modules.add(new Module("Datastructures", 3));
        modules.add(new Module("Pr. Enterprise Web Application Techno", 4));
        modules.add(new Module("Pr. Enterprise Web Application Individueel", 5));
        modules.add(new Module("Pr. Enterprise Web Application doc", 6));
        modules.add(new Module("OOAD", 3));
        modules.add(new Module("Professional Skills 2.1a", 3));
        modules.add(new Module("Professional Skills 2.1b", 3));
        modules.add(new Module("Sorting & Searching", 3));

        //Semester 4
        modules.add(new Module("Bedrijfspunt (Mob. Developm.)", 1));
        modules.add(new Module("Mobile Application Development", 4));
        modules.add(new Module("Mobile Design & Prototyping", 4));
        modules.add(new Module("Mobile Infrastructure & Sec.", 4));
        modules.add(new Module("Mobile Society", 4));
        modules.add(new Module("Project Mobile Development", 11));
        modules.add(new Module("Professional Skills MobDev.", 2));

        return modules;
    }

    private void populateGroup(StudentProfile sp1, StudentProfile sp2/*, StudentProfile sp3*/) {

        SchoolYear schoolYear1 = schoolYearDao.findOne(1L);
        SchoolYear schoolYear2 = schoolYearDao.findOne(2L);

        CourseGroup id101 = new CourseGroup("FDMCI_ID101", Arrays.asList(sp1), schoolYear1);
        CourseGroup id1s1 = new CourseGroup("FDMCI_ID1S1", Arrays.asList(sp2), schoolYear1);
//		CourseGroup id2s1 = new CourseGroup("FDMCI_ID2S1", Arrays.asList(sp3), schoolYear2);

        groupDao.save(Arrays.asList(id101, id1s1/*, id2s1*/));

        schoolYear1.setGroups(Arrays.asList(id101, id1s1));
//		schoolYear2.setGroups(Arrays.asList(id2s1));

        schoolYearDao.save(Arrays.asList(schoolYear1, schoolYear2));

        sp1.setCourseGroup(id101);
        sp2.setCourseGroup(id1s1);
//		sp3.setCourseGroup(id2s1);

        studentProfileDao.save(Arrays.asList(sp1, sp2/*, sp3*/));
    }

    private void populateExam(StudentProfile sp1, StudentProfile sp2/*, StudentProfile sp3*/) {

        int i = 0;
        List<Exam> exams = new ArrayList();
        List<Exam> examForResults = new ArrayList();
        Set<ExamRegistration> examRegistrations1 = new HashSet();
        Set<ExamRegistration> examRegistrations2 = new HashSet();
        
        Date date = new Date();
        for (SchoolYear schoolYear : schoolYearDao.findAll()) {
            for (Semester semester : schoolYear.getSemesters()) {
                for (Block block : semester.getBlocks()) {
                    Calendar cl = Calendar.getInstance();
                    cl.setTime(block.getEndDate());
                    cl.add(Calendar.DATE, -7);
                    for (Module module : block.getModules()) {
                        i++;
                        if (i % 2 == 0) {
                            cl.add(Calendar.DATE, 3);
                        } else {
                            cl.add(Calendar.DATE, -3);
                        }
                        Exam exam = new Exam(cl.getTime(), module, ExamType.NORMAL, null);
                        exams.add(exam);
                        if (!(block.getStartDate().before(date) && block.getEndDate().after(date))) {
                            examForResults.add(exam);
                            examRegistrations1.add(new ExamRegistration(exam, block, sp1, true));
                            examRegistrations2.add(new ExamRegistration(exam, block, sp2, true));
                        }else{
                            examRegistrations1.add(new ExamRegistration(exam, block, sp1, false));
                            examRegistrations2.add(new ExamRegistration(exam, block, sp2, false));
                        }
                    }
                    i = 0;
                }
            }
        }
        
        examDao.save(exams);
        examRegistrationDao.save(examRegistrations1);
        examRegistrationDao.save(examRegistrations2);
        
        List<ExamResult> ersSp1 = new ArrayList();
        List<ExamResult> ersSp2 = new ArrayList();
        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.ENGLISH);
        otherSymbols.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("#.#", otherSymbols);
        Random r1 = new Random();
        for (Exam exam : examForResults) {
            double d1 = 1.0 + r1.nextDouble() * 9.0;
            double d2 = 1.0 + r1.nextDouble() * 9.1;
            df.setRoundingMode(RoundingMode.CEILING);
            Double result1 = Double.parseDouble(df.format(d1));
            int ects1 = result1 >= 5.5 ? exam.getModule().getEcts() : 0;
            Double result2 = Double.parseDouble(df.format(d2));
            int ects2 = result2 >= 5.5 ? exam.getModule().getEcts() : 0;
            ExamResult er1 = new ExamResult(exam, sp1, result1, ects1);
            ersSp1.add(er1);
            ExamResult er2 = new ExamResult(exam, sp2, result2, ects2);
            ersSp2.add(er2);
            examResultDao.save(Arrays.asList(er1, er2));
            exam.setExamResults(Arrays.asList(er1, er2));
            examDao.save(exam);
        }

        sp1.setExamResults(ersSp1);
        sp2.setExamResults(ersSp2);
        studentProfileDao.save(Arrays.asList(sp1, sp2/*, sp3*/));
    }
}
