# Playwright Java Maven Project

This is a sample Playwright project for browser automation and testing using Java with Maven. The project uses TestNG for testing and assertions and follows the Page Object Model (POM) design pattern.

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [Writing Tests](#writing-tests)
- [Running Tests](#running-tests)
- [Configuration](#configuration)
- [License](#license)

## Installation

To get started with this Playwright project, you need to have Java and Maven installed.

1. Clone the repository:

    ```bash
    git clone https://github.com/obeyesekera/PlayWright.git
    cd PlayWright
    ```

2. Install the required dependencies:

    ```bash
    mvn clean install
    ```

## Usage

Here is a simple example of how to use Playwright with the Page Object Model in a TestNG test case:

```java
import com.microsoft.playwright.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class ExampleTest {
    private Playwright playwright;
    private Browser browser;
    private Page page;

    @BeforeClass
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
    }

    @Test
    public void testExample() {
        page.navigate("https://example.com");
        assertEquals(page.title(), "Example Domain");
    }

    @AfterClass
    public void tearDown() {
        browser.close();
        playwright.close();
    }
}
```

## Writing Tests

Tests are written using TestNG and the Page Object Model. Below is an example of a page object and a corresponding test case.

1. Create a page object (`ExamplePage.java`):

    ```java
    import com.microsoft.playwright.Page;

    public class ExamplePage {
        private final Page page;
        private final String url = "https://example.com";

        public ExamplePage(Page page) {
            this.page = page;
        }

        public void navigate() {
            page.navigate(url);
        }

        public String getTitle() {
            return page.title();
        }
    }
    ```

2. Create a test case (`ExamplePageTest.java`):

    ```java
    import com.microsoft.playwright.*;
    import org.testng.annotations.AfterClass;
    import org.testng.annotations.BeforeClass;
    import org.testng.annotations.Test;
    import static org.testng.Assert.assertEquals;

    public class ExamplePageTest {
        private Playwright playwright;
        private Browser browser;
        private Page page;
        private ExamplePage examplePage;

        @BeforeClass
        public void setUp() {
            playwright = Playwright.create();
            browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            page = browser.newPage();
            examplePage = new ExamplePage(page);
        }

        @Test
        public void testExamplePageTitle() {
            examplePage.navigate();
            assertEquals(examplePage.getTitle(), "Example Domain");
        }

        @AfterClass
        public void tearDown() {
            browser.close();
            playwright.close();
        }
    }
    ```

## Running Tests

To run your tests, use the following Maven command:

```bash
mvn test
```

## Configuration

You can configure Playwright settings in the `playwright.config.java` file. Here is an example configuration:

```java
import com.microsoft.playwright.*;

public class PlaywrightConfig {
    public static BrowserType.LaunchOptions getLaunchOptions() {
        return new BrowserType.LaunchOptions().setHeadless(false).setViewportSize(1280, 720);
    }
}
```

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.