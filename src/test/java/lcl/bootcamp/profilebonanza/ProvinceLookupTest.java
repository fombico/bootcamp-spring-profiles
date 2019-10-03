package lcl.bootcamp.profilebonanza;

import lcl.bootcamp.profilebonanza.lookup.ABProvinceLookup;
import lcl.bootcamp.profilebonanza.lookup.ProvinceLookup;
import lcl.bootcamp.profilebonanza.lookup.SKProvinceLookup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DisplayName("Province Lookup Test")
class ProvinceLookupTest {

    @Nested
    @SpringBootTest
    @ActiveProfiles("sk")
    @DisplayName("Saskatchewan")
    class Saskatchewan {

        @Autowired
        private ProvinceLookup provinceLookup;

        @Test
        @DisplayName("returns SK variant")
        void returnsSkVariant() {
            assertThat(provinceLookup).isInstanceOf(SKProvinceLookup.class);
        }

        @Test
        @DisplayName("returns province from application-sk.yml")
        void returnsProvinceFromApplicationSkYml() {
            assertThat(provinceLookup.getProvinceName()).isEqualTo("Saskatchewan");
        }

        @Test
        @DisplayName("returns color from base application yml")
        void returnsColorFromBaseApplicationYml() {
            assertThat(provinceLookup.getColor()).isEqualTo("Red");
        }

        @Test
        @DisplayName("returns province code from @Profile('SK') bean")
        void returnsProvinceCodeConfiguredFromBean() {
            assertThat(provinceLookup.getProvinceCode()).isEqualTo("SK");
        }
    }

    @Nested
    @SpringBootTest
    @ActiveProfiles("ab")
    @DisplayName("Alberta")
    class Alberta {

        @Autowired
        private ProvinceLookup provinceLookup;

        @Test
        @DisplayName("returns AB variant")
        void returnsAbVariant() {
            assertThat(provinceLookup).isInstanceOf(ABProvinceLookup.class);
        }

        @Test
        @DisplayName("returns province from application-ab.yml")
        void returnsProvinceFromApplicationAbYml() {
            assertThat(provinceLookup.getProvinceName()).isEqualTo("Alberta");
        }

        @Test
        @DisplayName("returns color from overridden application yml")
        void returnsColorFromOverriddenApplicationYml() {
            assertThat(provinceLookup.getColor()).isEqualTo("Blue");
        }

        @Test
        @DisplayName("returns province code from @Profile('AB') bean")
        void returnsProvinceCodeConfiguredFromBean() {
            assertThat(provinceLookup.getProvinceCode()).isEqualTo("AB");
        }
    }
}