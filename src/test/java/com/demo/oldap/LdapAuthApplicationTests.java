package com.demo.oldap;

import com.unboundid.ldap.sdk.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LdapAuthApplicationTests {

    private LDAPConnection ldapConnection;

    @Test
    void testLdapBindUser() throws LDAPException {

        BindResult bindResult = ldapConnection.bind("uid=iic111129,ou=People,dc=gandou,dc=iic,dc=local", "1234");

        Assert.isTrue(ResultCode.SUCCESS.equals(bindResult.getResultCode()), "bindResult status not equals status");

        SearchResultEntry entry = ldapConnection.getEntry("uid=iic111129,ou=People,dc=gandou,dc=iic,dc=local");
        String employeeNumber = entry.getAttribute("employeenumber").getValue();

        Assert.isTrue(employeeNumber != null, "employeeNumber is null");
        Assert.isTrue(employeeNumber.equals("8111129"), "employeeNumber is not equals 8111129");

    }

    @BeforeAll
    private void createLdapConnection() throws LDAPException {
        ldapConnection = new LDAPConnection("rep.gandou.iic.local", 389);
    }
}
