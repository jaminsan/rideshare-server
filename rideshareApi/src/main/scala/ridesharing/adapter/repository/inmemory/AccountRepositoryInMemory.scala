package ridesharing.adapter.repository.inmemory

import cats.Applicative
import cats.implicits._
import ridesharing.adapter.endpoint.controllers.auth.passenger.{Account, AccountRepository}
import ridesharing.domain.passenger.Passenger

import scala.collection.concurrent.TrieMap
import scala.util.Random

class AccountRepositoryInMemory[F[_]: Applicative] extends AccountRepository[F] {

  private val cache = new TrieMap[Account, Passenger]

  private val random = new Random()

  def store(e: Account, p: Passenger): F[Passenger] = {
    val id    = random.nextLong()
    val saved = p.copy(id = id.some)
    cache.put(e, saved)
    saved.pure[F]
  }

  def find(e: Account): F[Option[Passenger]] =
    cache.get(e).pure[F]
}

object AccountRepositoryInMemory {

  def apply[F[_]: Applicative](): AccountRepositoryInMemory[F] = new AccountRepositoryInMemory[F]()
}
