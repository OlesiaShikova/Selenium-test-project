# Selenium Test Project

Ein kleines Übungsprojekt zur Webautomatisierung mit **Selenium WebDriver** und **JUnit 5**, umgesetzt nach dem **Page Object Model**-Entwurfsmuster.

## Ziel des Projekts

Praktische Auseinandersetzung mit Testautomatisierung: Aufbau eines automatisierten Browser-Tests, der eine Google-Suche durchführt, inklusive Umgang mit dynamischen UI-Elementen (Cookie-Consent-Banner) und stabilen Wartestrategien.

## Verwendete Technologien

- **Java 21**
- **Selenium WebDriver 4.47.0**
- **JUnit 5** (Jupiter)
- **Maven** als Build-Tool

## Projektstruktur

```
src/
├── main/java/
│   └── GooglePage.java      # Page Object: kapselt alle Interaktionen mit der Google-Seite
└── test/java/
    └── GoogleSearchTest.java # JUnit-Test, nutzt GooglePage
```

## Was das Projekt zeigt

- **Page Object Model**: Trennung von Testlogik und Seiteninteraktion — Locators und Aktionen sind zentral in `GooglePage` gekapselt, statt im Test verstreut
- **Explizite Waits**: Nutzung von `WebDriverWait` und `ExpectedConditions` statt starrer `Thread.sleep()`-Aufrufe, um stabile statt "flaky" Tests zu erhalten
- **Umgang mit dynamischen UI-Elementen**: Der Test behandelt das Cookie-Consent-Banner von Google, das nicht immer in gleicher Form/Zeit erscheint
- **JUnit-Lifecycle**: `@BeforeEach`/`@AfterEach` für sauberes Setup und Teardown des Browsers pro Test

## Testfall

`googleSearch_shouldShowResultsPage`:
1. Öffnet Google
2. Akzeptiert den Cookie-Banner, falls vorhanden
3. Führt eine Suche durch
4. Prüft, dass der Seitentitel den Suchbegriff enthält

## Lokale Ausführung

```bash
mvn test
```

Voraussetzung: Google Chrome ist installiert (Selenium Manager lädt den passenden ChromeDriver automatisch).

## Nächste Schritte

- Weitere Testfälle ergänzen (z. B. negative Testfälle)
- Testdaten extern auslagern (z. B. über CSV/JSON)
- CI-Integration (z. B. GitHub Actions) für automatische Testläufe bei jedem Push
