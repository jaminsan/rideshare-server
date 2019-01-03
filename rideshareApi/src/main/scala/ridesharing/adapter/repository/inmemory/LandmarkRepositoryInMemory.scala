package ridesharing.adapter.repository.inmemory

import cats._
import cats.implicits._
import ridesharing.domain.passenger.landmark.{Landmark, LandmarkRepository}

import scala.collection.concurrent.TrieMap
import scala.util.Random

class LandmarkRepositoryInMemory[F[_]: Applicative] extends LandmarkRepository[F] {

  private val cache = new TrieMap[Long, Landmark]

  // TODO: UUID
  private val random = new Random

  override def store(e: Landmark): F[Landmark] = {
    val id     = random.nextLong()
    val toSave = e.copy(id = id.some)
    toSave.id.foreach { cache.put(_, toSave) }
    toSave.pure[F]
  }

  override def findById(id: Long): F[Option[Landmark]] =
    cache.get(id).pure[F]

  override def findListByPassengerId(passengerId: Long): F[List[Landmark]] =
    cache.values.filter(_.passengerId == passengerId).toList.pure[F]
}

object LandmarkRepositoryInMemory {

  def apply[F[_]: Applicative](): LandmarkRepositoryInMemory[F] = new LandmarkRepositoryInMemory[F]()
}
