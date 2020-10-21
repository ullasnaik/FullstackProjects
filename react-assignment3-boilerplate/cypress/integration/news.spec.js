describe("Keep application test cases", () => {
    beforeEach(() => {
        cy.visit('/')
    })
    it('display the dashboard for endpoint', () => {
        cy.get('input[name = username]').type('admin');
        cy.wait(1000);
        cy.get('input[name = password]').type('password{enter}')
        cy.wait(1000);
        cy.get('[id="endpoints"]').click()
        cy.wait(1000);
        cy.get('[id="everything"]').click()
        cy.wait(3000);
    })

    it('display the dashboard for country filter', () => {
        cy.get('input[name = username]').type('admin');
        cy.wait(1000);
        cy.get('input[name = password]').type('password{enter}')
        cy.wait(1000);
        cy.get('[id="country"]').click()
        cy.wait(1000);
        cy.get('[id="au"]').click()
        cy.wait(3000);
    })

    it('display the dashboard category filter', () => {
        cy.get('input[name = username]').type('admin');
        cy.wait(1000);
        cy.get('input[name = password]').type('password{enter}')
        cy.wait(1000);
        cy.get('[id="category"]').click()
        cy.wait(1000);
        cy.get('[id="entertainment"]').click()
        cy.wait(3000);
    })

    it('display the dashboard for key search', () => {
        cy.get('input[name = username]').type('admin');
        cy.wait(1000);
        cy.get('input[name = password]').type('password{enter}')
        cy.wait(1000);
        cy.get('[id="endpoints"]').click()
        cy.wait(1000);
        cy.get('[id="everything"]').click()
        cy.wait(1000);
        cy.get('input[name = key]').type('sushant')
        cy.wait(1000);
        cy.get('[name="search"]').click()
        cy.wait(3000);
    })
})
