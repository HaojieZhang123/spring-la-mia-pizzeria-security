# EX - La Mia Pizzeria REST Security

## Consegna

**Repo**: `spring-la-mia-pizzeria-security`

> Ricordatevi di sganciare la vostra vecchia repository e di crearne una nuova per questo esercizio, che prosegue il lavoro della pizzeria, dove lo avevate lasciato.


Finalmente proteggiamo la nostra applicazione!

Abbiamo sviluppato tutte le pagine per gestire la nostra pizzeria (elenco pizze, dettagli singola pizza, creazione, modifica, cancellazione, offerte speciali, ingredienti)…ma vogliamo che chiunque possa effettuare queste operazioni? Sicuramente no!

Quindi inseriamo l’autenticazione in modo che solo gli utenti registrati possano accedere a queste pagine.

Creiamo le entity necessarie e popoliamo a mano i dati degli utenti nel database.

Sono previsti due ruoli : **USER** e **ADMIN**
Chi avrà assegnato come ruolo **USER** potrà accedere solo alla pagina index e a quella di dettaglio.
Chi invece avrà assegnato come ruolo **ADMIN** potrà fare tutto.

Buon lavoro!! 🙂

---

### Personal notes:

Non funziona. 

Quando eseguito, non genera password di default.
Restituisce errno: 150 "Foreign key constraint is incorrectly formed"
In DB non forma le table correttamente

Provato a cambiare DB in uno vuoto, con:
spring.jpa.hibernate.ddl-auto=create

Non viene generato default password.
WARN 388300 --- [spring-la-mia-pizzeria-security] [  restartedMain] r$InitializeUserDetailsManagerConfigurer : Global AuthenticationManager configured with an AuthenticationProvider bean. UserDetailsService beans will not be used by Spring Security for automatically configuring username/password login. Consider removing the AuthenticationProvider bean. Alternatively, consider using the UserDetailsService in a manually instantiated DaoAuthenticationProvider. If the current configuration is intentional, to turn off this warning, increase the logging level of 'org.springframework.security.config.annotation.authentication.configuration.InitializeUserDetailsBeanManagerConfigurer' to ERROR
Nessun errore particolare
Autenticazione sembra funzionare correttamente, una volta inserito manualmente nel DB alcuni utenti e ruoli.

Cambiando impostazioni hibernate nuovamente in update, parte di Spring Security sembra non esistere proprio. 

Cambiando DB non cambia il risultato questa volta

