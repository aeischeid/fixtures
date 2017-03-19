import grails.test.mixin.integration.Integration
import grails.transaction.Rollback
import spock.lang.*
import test.MixinTarget

@Integration
@Rollback
class MixinSpec extends Specification {

	def fixtureLoader

	def "load object with mixin"() {
		when:
		def f = fixtureLoader.load {
			m(MixinTarget) {
				name = "foo"
			}
		}

		then:
		f.m.name == "foo"
	}
}
