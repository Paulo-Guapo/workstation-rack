package com.ctw.workstation.Simple;

import com.ctw.workstation.HelloAcademy;
import org.assertj.core.api.Assertions;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) // para poder dar inject de mocks

@TestInstance(TestInstance.Lifecycle.PER_CLASS)//por default é gerado uma instance é por method
//^ por class posso usar a cenas nos methdos staticos porque todos passam a partilhas as coisas
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class HelloAcademyTest {

    /*
    //tenho de meter a pasta Simple?

    HelloAcademy helloAcademy;

    private static final Logger log = Logger.getLogger(HelloAcademyTest.class);

    @BeforeAll
    void init() { // nao é static e nao dá erro?
        helloAcademy = new HelloAcademy();
        log.info("before all tests");
    }

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
        log.info("after each test");
    }

    @AfterAll
    static void tearDownClass() {
        log.info("after all tests");
    }


    public static Stream<Arguments> provide_null_name() { //shortcut -> ctrl + w // shortcut -> ctrl + shift + setas
        return Stream.of(
                Arguments.of("maria", "Hello maria")
        );
    }

    @Order(1)
    @ParameterizedTest
    @MethodSource(value = "provide_null_name")// posso nao ter nada dentro porque ele implicitamente sabe pelo mesmo nome, mas se ele mudar tenho de meter com o value = [metod]
    // teste para varias coisas ao mesmo tempo ^
    @DisplayName("when providing a null name to say hello, just hello shoud be returned") // combinar isto
    void provide_null_name(String name, String expected){

        //given
        //HelloAcademy helloAcademy = new HelloAcademy(); // já tenho lá em cima, desta vez para todos
        //when //ctrl + shift + v ou bla.var + enter -> para dar complete
        String ActualName = helloAcademy.sayHello(name);
        //then
        assertAll(
                ()-> assertNotNull(ActualName),
                ()-> assertEquals(expected, ActualName, "Return should be just Hello when providing a null name")
        );
        //assertNotNull(ActualName);
        //assertEquals(expected, ActualName, "Return should be just Hello when providing a null name");//com este texto

    }

    @Order(2)
    @Test
    @DisplayName("when providing a emply name to say hello, just hello should be returned")
    void provide_empty_name(){

        HelloAcademy helloAcademy = new HelloAcademy();
        String name = "";
        String ActualName = helloAcademy.sayHello(name);
        assertEquals("Hello " + name, ActualName, "Return should be just Hello(with space) when providing a space name");

        //Assertions.assertThat(helloAcademy.sayHello(name)).isNull(); // assertj stuffs

    }

    @Order(3)
    @Test
    @DisplayName("when providing a non name, should return Hello(with space)")
    void prodive_characters_as_name(){

        HelloAcademy helloAcademy = new HelloAcademy();
        String name = "12345";
        String ActualName = helloAcademy.sayHello(name);

        assertEquals("Hello " + name, ActualName, "Should return Hello(With space) when providing a non nama.");

    }

    */

    //@Mock //@Spy ou @Mock
    //ExternalMessageService externalMessageServiceMock; // -> este é a interface

    @Spy //@Spy ou @Mock // tmb posso usar spy aqui, como anotaçao
    ExternalMessageServiceImpl externalMessageServiceMock; // -> este é a class(objeto)

    @InjectMocks // inject mocks todos aqui neste gajo // posso ter varios InjectMocks? provavelmente posso se estiverem em ordem uns do outros?
    HelloAcademy helloAcademy;

    @BeforeEach
    void setUp() {
        externalMessageServiceMock = Mockito.spy(new ExternalMessageServiceImpl()); // implementaçao da interface -> class
        //externalMessageServiceMock = Mockito.mock(ExternalMessageService.class); // mock da interface
        helloAcademy = new HelloAcademy(externalMessageServiceMock);
        //helloAcademy = new HelloAcademy();

        //Carservice carService = Mockito.mock(Carservice.class);

    }

    @Test
    @DisplayName("when providing a null name a message from outer space apears")
    void when_providing_a_null_name_a_message_from_outer_space_apears(){

        //given
        String name = null;

        //when
        //String actualName = helloAcademy.sayHello(name);
        //Mockito.when(externalMessageServiceMock.sayHelloFromOuterSpace()).thenReturn("Hello from outer Space"); // para o mock
        //Mockito.doReturn("Hello from outer Space " + name).when(externalMessageServiceMock).sayHelloFromOuterSpace(name);
        //^ para o spy -> a ordem é ao contrario do outro -> ver melhor como é -> a ideia é como é um objeto real tenho de evitar chamar o objeto antes de returnar -> o objeto executa de facto e mock kinda
        //^melhor explicação, como eu crio o objeto, ao inicio ele nao tem nada, entao tenho de adiconar os dados primeiro do "doReturn", e depois é que faço o get do objeto

        //when(externalMessageServiceMock.sayHelloFromOuterSpace(name)).thenReturn("Hello from outer Space"); // se nao usar a extenção a validação nao é feita
        //when(externalMessageServiceMock.sayHelloFromOuterSpace()).thenReturn("Hello from outer Space"); // posso usar agora porcausa dos Injects?

        //Mockito.doThrow(NullPointerException.class).when(externalMessageServiceMock).sayHelloFromOuterSpace(); // ver se o trow acontece
        Mockito.doNothing().when(externalMessageServiceMock).fazAlgo(); // posso ignorar a execução de sertos methodos dentro do objeto

        String actualName = helloAcademy.sayHello(name); // tenho e meter depois
        //then
        assertEquals("Hello from outer Space", actualName);

        //Mockito.verify(carService).doSomething(); // verificar car service -> posso ver quantas vezes foi chamado adicionando numeros

    }

    @Test
    @DisplayName("when providing valid name a message from outer space apears")
    void when_providing_name_valid_a_message_from_outer_space_apears(){

        //given
        String name = "jaquim";
        String outroNome = "zé";
        //when
        //String actualName = helloAcademy.sayHello(name);
        when(externalMessageServiceMock.sayHelloFromOuterSpace(Mockito.anyString())).thenReturn("Hello from outer Space");
        //^ Mockito.anyString() -> o gajo dá match
        String actualName = helloAcademy.sayHello(name); // tenho e meter depois
        //then
        assertEquals("Hello from outer Space", actualName);

    }

}