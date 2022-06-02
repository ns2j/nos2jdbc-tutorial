package nos2jdbc.tutorial.kotlinspring.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import nos2jdbc.tutorial.kotlinspring.gen.service.ClubMemberRelServiceBase

@Service
@Transactional
class ClubMemberRelService: ClubMemberRelServiceBase() {
}