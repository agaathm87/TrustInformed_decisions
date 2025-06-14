package asl
 import _root_.scala.collection.mutable.HashMap

 import _root_.akka.actor.typed.{ActorRef, Behavior, SupervisorStrategy}
 import _root_.akka.actor.typed.scaladsl.{ActorContext, Behaviors, Routers}
 import java.util.logging.Logger
 import _root_.scala.util.Failure
 import _root_.scala.util.Success
 import _root_.akka.util.Timeout
 import _root_.scala.concurrent.duration._
 import _root_.akka.actor.typed.scaladsl.AskPattern._
 import _root_.scala.language.implicitConversions
 import _root_.scala.concurrent.{Await, Future}
 import _root_.scala.jdk.CollectionConverters._
 import std.converters._

 import scala.util.Random
 import bb._
 import infrastructure._
 import bb.expstyla.exp._
 import std.{AgentCommunicationLayer, DefaultCommunications}

 class agent  (coms: AgentCommunicationLayer = new  DefaultCommunications,
                                     beliefBaseFactory: IBeliefBaseFactory = new StylaBeliefBaseFactory)
                      extends IntentionalAgentFactory {


 object Intention {

       def apply(p_executionContext: ExecutionContext): Behavior[ISubGoalMessage] = Behaviors.setup { context =>

         Behaviors.receive {
         (context, message) =>

          implicit val executionContext = p_executionContext.copy(intention = context, src = message.source)

         message match {
            case SubGoalMessage(_,_,r) =>
               message.goal match {

           case _ =>
             context.log.error("This actor can not handle goal of type {}", message.goal)
         }
           r match {
                 case a : AkkaMessageSource => 
                   a.src ! IntentionDoneMessage(AkkaMessageSource(executionContext.agent.self))
                 case DummyMessageSource(_) => 
                   context.log.error("Intention Done!")
               }

               Behaviors.same
             case InitEndMessage(r) =>
               Behaviors.stopped
       }
      }
     }
     }

 override def agentBuilder: Agent = new Agent()
 class Agent extends IAgent {

         override def agent_type: String = "agent"

         var vars = VarMap()

         def initGoals()(implicit executionContext: ExecutionContext) = List[StructTerm](
         )

         def initBeliefs()(implicit executionContext: ExecutionContext) = List[StructTerm](
                     StructTerm("agent",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]())))
           ,
            StructTerm("agent",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]())))
           ,
            StructTerm("agent",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]())))
           ,
            StructTerm("trustor",Seq[GenericTerm](StructTerm("anna",Seq[GenericTerm]())))
           ,
            StructTerm("trust",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),DoubleTerm(0.5)))
           ,
            StructTerm("trust",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),DoubleTerm(0.5)))
           ,
            StructTerm("trust",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),DoubleTerm(0.5)))
           ,
            StructTerm("goal",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]())))
           ,
            StructTerm("goal",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]())))
           ,
            StructTerm("goal",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]())))
           ,
            StructTerm("goal",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]())))
           ,
            StructTerm("goal",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]())))
           ,
            StructTerm("goal",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]())))
           ,
            StructTerm("subplan",Seq[GenericTerm](StructTerm("gardening",Seq[GenericTerm]()),StructTerm("weeding",Seq[GenericTerm]())))
           ,
            StructTerm("subplan",Seq[GenericTerm](StructTerm("cleaning",Seq[GenericTerm]()),StructTerm("dusting",Seq[GenericTerm]())))
           ,
            StructTerm("benevolence",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("fun",Seq[GenericTerm]()),IntTerm(0),IntTerm(0)))
           ,
            StructTerm("benevolence",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("health",Seq[GenericTerm]()),IntTerm(0),IntTerm(0)))
           ,
            StructTerm("benevolence",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("fun",Seq[GenericTerm]()),IntTerm(0),IntTerm(0)))
           ,
            StructTerm("benevolence",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("health",Seq[GenericTerm]()),IntTerm(0),IntTerm(0)))
           ,
            StructTerm("benevolence",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("fun",Seq[GenericTerm]()),IntTerm(0),IntTerm(0)))
           ,
            StructTerm("benevolence",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("health",Seq[GenericTerm]()),IntTerm(0),IntTerm(0)))
           ,
            StructTerm("phi",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("fun",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),DoubleTerm(0.9)))
           ,
            StructTerm("phi",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("health",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),DoubleTerm(1.0)))
           ,
            StructTerm("phi",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("fun",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),DoubleTerm(0.1)))
           ,
            StructTerm("phi",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("health",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),DoubleTerm(0.1)))
           ,
            StructTerm("phi",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("fun",Seq[GenericTerm]()),StructTerm("repairing",Seq[GenericTerm]()),DoubleTerm(0.6)))
           ,
            StructTerm("phi",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("health",Seq[GenericTerm]()),StructTerm("repairing",Seq[GenericTerm]()),DoubleTerm(0.6)))
           ,
            StructTerm("phi",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("fun",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),DoubleTerm(0.8)))
           ,
            StructTerm("phi",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("health",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),DoubleTerm(0.9)))
           ,
            StructTerm("phi",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("fun",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),DoubleTerm(0.2)))
           ,
            StructTerm("phi",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("health",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),DoubleTerm(0.3)))
           ,
            StructTerm("phi",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("fun",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),DoubleTerm(0.7)))
           ,
            StructTerm("phi",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("health",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),DoubleTerm(0.8)))
           ,
            StructTerm("phi",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("fun",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),DoubleTerm(0.3)))
           ,
            StructTerm("phi",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("health",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),DoubleTerm(0.2)))
           ,
            StructTerm("principle",Seq[GenericTerm](StructTerm("gardening",Seq[GenericTerm]()),StructTerm("honesty",Seq[GenericTerm]()),DoubleTerm(0.8)))
           ,
            StructTerm("principle",Seq[GenericTerm](StructTerm("gardening",Seq[GenericTerm]()),StructTerm("reliability",Seq[GenericTerm]()),DoubleTerm(0.7)))
           ,
            StructTerm("principle",Seq[GenericTerm](StructTerm("cleaning",Seq[GenericTerm]()),StructTerm("honesty",Seq[GenericTerm]()),DoubleTerm(0.3)))
           ,
            StructTerm("principle",Seq[GenericTerm](StructTerm("cleaning",Seq[GenericTerm]()),StructTerm("reliability",Seq[GenericTerm]()),DoubleTerm(0.9)))
           ,
            StructTerm("intention",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]())))
           ,
            StructTerm("intention",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]())))
           ,
            StructTerm("intention",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]())))
           ,
            StructTerm("intention",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]())))
           ,
            StructTerm("offer",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),StructTerm("offer2",Seq[GenericTerm]())))
           ,
            StructTerm("offer",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("repairing",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),StructTerm("offer1",Seq[GenericTerm]())))
           ,
            StructTerm("offer",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),StructTerm("offer3",Seq[GenericTerm]())))
           ,
            StructTerm("offer",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),StructTerm("offer4",Seq[GenericTerm]())))
           ,
            StructTerm("reject",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("offer2",Seq[GenericTerm]()),StructTerm("fun",Seq[GenericTerm]())))
           ,
            StructTerm("reject",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("offer2",Seq[GenericTerm]()),StructTerm("health",Seq[GenericTerm]())))
           ,
            StructTerm("succes",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]())))
           ,
            StructTerm("failure",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]())))
           ,
            StructTerm("value",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("honesty",Seq[GenericTerm]()),DoubleTerm(0.7)))
           ,
            StructTerm("value",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("reliability",Seq[GenericTerm]()),DoubleTerm(0.8)))
           ,
            StructTerm("value",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("honesty",Seq[GenericTerm]()),DoubleTerm(0.5)))
           ,
            StructTerm("value",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("reliability",Seq[GenericTerm]()),DoubleTerm(0.9)))
           ,
            StructTerm("value",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("honesty",Seq[GenericTerm]()),DoubleTerm(0.9)))
           ,
            StructTerm("value",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("reliability",Seq[GenericTerm]()),DoubleTerm(0.6)))
           ,
            StructTerm("knowledge",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),StructTerm("edible",Seq[GenericTerm]()),DoubleTerm(0.8)))
           ,
            StructTerm("resource",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),StructTerm("tools",Seq[GenericTerm]()),DoubleTerm(0.2)))
           ,
            StructTerm("resource",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),StructTerm("time",Seq[GenericTerm]()),DoubleTerm(0.5)))
           ,
            StructTerm("skill",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),StructTerm("ability",Seq[GenericTerm]()),DoubleTerm(0.9)))
           ,
            StructTerm("knowledge",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("weeding",Seq[GenericTerm]()),StructTerm("herbology",Seq[GenericTerm]()),DoubleTerm(0.7)))
           ,
            StructTerm("resource",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("weeding",Seq[GenericTerm]()),StructTerm("tools",Seq[GenericTerm]()),DoubleTerm(0.6)))
           ,
            StructTerm("skill",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("weeding",Seq[GenericTerm]()),StructTerm("ability",Seq[GenericTerm]()),DoubleTerm(0.8)))
           ,
            StructTerm("knowledge",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),StructTerm("surfaces",Seq[GenericTerm]()),DoubleTerm(0.5)))
           ,
            StructTerm("resource",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),StructTerm("vacuum",Seq[GenericTerm]()),DoubleTerm(0.6)))
           ,
            StructTerm("skill",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),StructTerm("thoroughness",Seq[GenericTerm]()),DoubleTerm(0.4)))
           ,
            StructTerm("knowledge",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("dusting",Seq[GenericTerm]()),StructTerm("surfaces",Seq[GenericTerm]()),DoubleTerm(0.6)))
           ,
            StructTerm("resource",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("dusting",Seq[GenericTerm]()),StructTerm("duster",Seq[GenericTerm]()),DoubleTerm(0.7)))
           ,
            StructTerm("skill",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("dusting",Seq[GenericTerm]()),StructTerm("attention",Seq[GenericTerm]()),DoubleTerm(0.5)))
           ,
            StructTerm("knowledge",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),StructTerm("edible",Seq[GenericTerm]()),DoubleTerm(0.8)))
           ,
            StructTerm("resource",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),StructTerm("tools",Seq[GenericTerm]()),DoubleTerm(0.2)))
           ,
            StructTerm("resource",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),StructTerm("time",Seq[GenericTerm]()),DoubleTerm(0.5)))
           ,
            StructTerm("skill",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),StructTerm("ability",Seq[GenericTerm]()),DoubleTerm(0.9)))
           ,
            StructTerm("knowledge",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("weeding",Seq[GenericTerm]()),StructTerm("herbology",Seq[GenericTerm]()),DoubleTerm(0.7)))
           ,
            StructTerm("resource",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("weeding",Seq[GenericTerm]()),StructTerm("tools",Seq[GenericTerm]()),DoubleTerm(0.6)))
           ,
            StructTerm("skill",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("weeding",Seq[GenericTerm]()),StructTerm("ability",Seq[GenericTerm]()),DoubleTerm(0.8)))
           ,
            StructTerm("knowledge",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),StructTerm("surfaces",Seq[GenericTerm]()),DoubleTerm(0.5)))
           ,
            StructTerm("resource",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),StructTerm("vacuum",Seq[GenericTerm]()),DoubleTerm(0.6)))
           ,
            StructTerm("skill",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),StructTerm("thoroughness",Seq[GenericTerm]()),DoubleTerm(0.4)))
           ,
            StructTerm("knowledge",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("dusting",Seq[GenericTerm]()),StructTerm("surfaces",Seq[GenericTerm]()),DoubleTerm(0.6)))
           ,
            StructTerm("resource",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("dusting",Seq[GenericTerm]()),StructTerm("duster",Seq[GenericTerm]()),DoubleTerm(0.7)))
           ,
            StructTerm("skill",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("dusting",Seq[GenericTerm]()),StructTerm("attention",Seq[GenericTerm]()),DoubleTerm(0.5)))
           ,
            StructTerm("knowledge",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),StructTerm("edible",Seq[GenericTerm]()),DoubleTerm(0.8)))
           ,
            StructTerm("resource",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),StructTerm("tools",Seq[GenericTerm]()),DoubleTerm(0.2)))
           ,
            StructTerm("resource",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),StructTerm("time",Seq[GenericTerm]()),DoubleTerm(0.5)))
           ,
            StructTerm("skill",Seq[GenericTerm](StructTerm("gardening",Seq[GenericTerm]()),StructTerm("ability",Seq[GenericTerm]()),DoubleTerm(0.9)))
           ,
            StructTerm("knowledge",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("weeding",Seq[GenericTerm]()),StructTerm("herbology",Seq[GenericTerm]()),DoubleTerm(0.7)))
           ,
            StructTerm("resource",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("weeding",Seq[GenericTerm]()),StructTerm("tools",Seq[GenericTerm]()),DoubleTerm(0.6)))
           ,
            StructTerm("skill",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("weeding",Seq[GenericTerm]()),StructTerm("ability",Seq[GenericTerm]()),DoubleTerm(0.8)))
           ,
            StructTerm("knowledge",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),StructTerm("surfaces",Seq[GenericTerm]()),DoubleTerm(0.5)))
           ,
            StructTerm("resource",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),StructTerm("vacuum",Seq[GenericTerm]()),DoubleTerm(0.6)))
           ,
            StructTerm("skill",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),StructTerm("thoroughness",Seq[GenericTerm]()),DoubleTerm(0.4)))
           ,
            StructTerm("knowledge",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("dusting",Seq[GenericTerm]()),StructTerm("surfaces",Seq[GenericTerm]()),DoubleTerm(0.6)))
           ,
            StructTerm("resource",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("dusting",Seq[GenericTerm]()),StructTerm("duster",Seq[GenericTerm]()),DoubleTerm(0.7)))
           ,
            StructTerm("skill",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("dusting",Seq[GenericTerm]()),StructTerm("attention",Seq[GenericTerm]()),DoubleTerm(0.5)))
           ,
            StructTerm(":-",Seq[GenericTerm](StructTerm("missing_or_zero_resource",Seq[GenericTerm](vars("A"),vars("Action"),vars("Condition"))),StructTerm(";",Seq[GenericTerm](StructTerm("not",Seq[GenericTerm](StructTerm("resource",Seq[GenericTerm](vars("A"),vars("Action"),vars("Condition"),vars("_"))))),StructTerm("resource",Seq[GenericTerm](vars("A"),vars("Action"),vars("Condition"),IntTerm(0)))))))
           ,
            StructTerm(":-",Seq[GenericTerm](StructTerm("missing_or_zero_skill",Seq[GenericTerm](vars("A"),vars("Action"),vars("Condition"))),StructTerm(";",Seq[GenericTerm](StructTerm("not",Seq[GenericTerm](StructTerm("skill",Seq[GenericTerm](vars("A"),vars("Action"),vars("Condition"),vars("_"))))),StructTerm("skill",Seq[GenericTerm](vars("A"),vars("Action"),vars("Condition"),IntTerm(0)))))))
           ,
            StructTerm(":-",Seq[GenericTerm](StructTerm("missing_or_zero_knowledge",Seq[GenericTerm](vars("A"),vars("Action"),vars("Condition"))),StructTerm(";",Seq[GenericTerm](StructTerm("not",Seq[GenericTerm](StructTerm("knowledge",Seq[GenericTerm](vars("A"),vars("Action"),vars("Condition"),vars("_"))))),StructTerm("knowledge",Seq[GenericTerm](vars("A"),vars("Action"),vars("Condition"),IntTerm(0)))))))
           ,
            StructTerm(":-",Seq[GenericTerm](StructTerm("missing_or_zero_benevolence",Seq[GenericTerm](vars("Agent"),vars("Value"))),StructTerm(";",Seq[GenericTerm](StructTerm("not",Seq[GenericTerm](StructTerm("benevolence",Seq[GenericTerm](vars("Agent"),vars("Value"),vars("_"),vars("_"))))),StructTerm("benevolence",Seq[GenericTerm](vars("Agent"),vars("Value"),vars("Bmin"),IntTerm(0)))))))
           ,
            StructTerm(":-",Seq[GenericTerm](StructTerm("missing_or_zero_value",Seq[GenericTerm](vars("Agent"),vars("Principle"),vars("Value"))),StructTerm(";",Seq[GenericTerm](StructTerm("value",Seq[GenericTerm](vars("Agent"),vars("Principle"),IntTerm(0))),StructTerm("not",Seq[GenericTerm](StructTerm("value",Seq[GenericTerm](vars("Agent"),vars("Principle"),vars("_")))))))))
           ,
            StructTerm(":-",Seq[GenericTerm](StructTerm("benevolence",Seq[GenericTerm](vars("A"),vars("Goal"),vars("BScore"))),StructTerm(",",Seq[GenericTerm](StructTerm("benevolence_offer",Seq[GenericTerm](vars("A"),vars("Goal"),vars("Bmin"),vars("Bmax"))),StructTerm("is",Seq[GenericTerm](vars("BScore"),StructTerm("/",Seq[GenericTerm](StructTerm("+",Seq[GenericTerm](vars("Bmin"),vars("Bmax"))),IntTerm(2)))))))))
           ,
            StructTerm("value_weight",Seq[GenericTerm](StructTerm("fun",Seq[GenericTerm]()),DoubleTerm(0.6)))
           ,
            StructTerm("value_weight",Seq[GenericTerm](StructTerm("health",Seq[GenericTerm]()),DoubleTerm(0.4)))
           ,
            StructTerm("totalbenmin",Seq[GenericTerm](IntTerm(0)))
           ,
            StructTerm("totalbenmax",Seq[GenericTerm](IntTerm(0)))
           ,
            StructTerm("number_of_values",Seq[GenericTerm](vars("_"),IntTerm(0)))
           ,
            StructTerm("accepted_values",Seq[GenericTerm](vars("_"),IntTerm(0)))
           ,
            StructTerm("total_combined_weight",Seq[GenericTerm](IntTerm(0)))
           ,
            StructTerm("weight_resource",Seq[GenericTerm](DoubleTerm(0.3)))
           ,
            StructTerm("weight_skill",Seq[GenericTerm](DoubleTerm(0.4)))
           ,
            StructTerm("weight_knowledge",Seq[GenericTerm](DoubleTerm(0.3)))
           ,
            StructTerm("number_of_subs",Seq[GenericTerm](vars("_"),IntTerm(0)))
           ,
            StructTerm("succeeded_subs",Seq[GenericTerm](vars("_"),IntTerm(0)))
           ,
            StructTerm("competence_sub",Seq[GenericTerm](vars("_"),vars("_"),IntTerm(0)))
           ,
            StructTerm("weight",Seq[GenericTerm](StructTerm("honesty",Seq[GenericTerm]()),DoubleTerm(0.6)))
           ,
            StructTerm("weight",Seq[GenericTerm](StructTerm("reliability",Seq[GenericTerm]()),DoubleTerm(0.4)))
           ,
            StructTerm("threshold",Seq[GenericTerm](DoubleTerm(0.7)))
           ,
            StructTerm("weight_competence",Seq[GenericTerm](DoubleTerm(0.4)))
           ,
            StructTerm("weight_benevolence",Seq[GenericTerm](DoubleTerm(0.6)))
           ,
            StructTerm("weight_integrity",Seq[GenericTerm](DoubleTerm(0.3)))
           ,
            StructTerm("threshold_trustworthiness",Seq[GenericTerm](StructTerm("gardening",Seq[GenericTerm]()),DoubleTerm(0.7)))
           ,
            StructTerm("goal_scores",Seq[GenericTerm](StructTerm("gardening",Seq[GenericTerm]()),DoubleTerm(0.75),DoubleTerm(0.85),DoubleTerm(0.9)))
           ,
            StructTerm("goal_scores",Seq[GenericTerm](StructTerm("cleaning",Seq[GenericTerm]()),DoubleTerm(0.65),DoubleTerm(0.8),DoubleTerm(0.85)))


         )

         def planApplicabilities()(implicit executionContext: ExecutionContext) = List[StructTerm](

                 )



      def apply(name: String, yellowPages: IYellowPages, MAS: ActorRef[IMessage], parent: IMessageSource): Behavior[IMessage] = {
           Behaviors.setup { context =>
             val yp: IYellowPages = yellowPages
             val bb: IBeliefBase[GenericTerm] = beliefBaseFactory()
             implicit val executionContext: ExecutionContext = ExecutionContext(
                            name = name,
                            agentType = agent_type,
                            agent = context,
                            yellowPages = yp,
                            beliefBase = bb,
                            logger = context.log,
                            goalParser = GoalParser,
                            parent = parent
                          )
             bb.assert(initBeliefs)
             bb.assert(planApplicabilities)

         val initiator = context.spawn(Intention(executionContext), "initiator")

         MAS ! ReadyMessage(context.self)
         Behaviors.receive {
           (context, message) =>
             message match {
               case StartMessage() =>


                 implicit val timeout: Timeout = 99999.seconds
                 implicit val ec = context.executionContext
                 implicit val scheduler = context.system.scheduler


                 //              initGoals.foreach( tuple => initiator ! SubGoalMessage(tuple._1,tuple._2,context.self))
                 initGoals.foreach(struct => {


                   val result: Future[IMessage] = initiator.ask[IMessage](ref => {
                     val subGoal = GoalParser.create_goal_message(struct, AkkaMessageSource(ref))
                     if (subGoal.isDefined)
                       subGoal.get
                     else
                       throw new RuntimeException(s"No plan for initial goal $struct")
                     }
                   )


                   //result.onComplete {
                   //  case Success(IntentionDoneMessage(r)) => IntentionDoneMessage(r)
                   //  case Failure(_) => IntentionErrorMessage(src = null)
                   //}

                   //Await.result(result, timeout.duration)

                   val res = Await.result(result, timeout.duration)

                   if(!res.isInstanceOf[IntentionDoneMessage]) {
                     throw new RuntimeException(s"Issue with initial goal $struct")
                     context.system.terminate()
                   }

                   //                context.ask[ISubGoalMessage, IMessage](initiator, ref => SubGoalMessage(tuple._1, tuple._2,name, ref)) {
                   //                  case Success(IntentionDoneMessage(_, _)) => IntentionDoneMessage()
                   //                  case Failure(_) => IntentionErrorMessage()
                   //                }
                 }
                 )

                 initiator ! InitEndMessage(context.self)
                 normal_behavior(MAS)

               //            case InitEndMessage(_) =>
               //              context.log.debug(f"$name: I have started, switching behavior")
               //              normal_behavior()
             }

         }
       }
     }

     def normal_behavior(MAS: ActorRef[IMessage])(implicit executionContext: ExecutionContext): Behavior[IMessage] = {
       Behaviors.setup { context =>

         val pool = Routers.pool(poolSize = 8)(
           Behaviors.supervise(Intention(executionContext)).onFailure[Exception](SupervisorStrategy.restart))

         val router = context.spawn(pool, "intention-pool")
         //MAS ! ReadyMessage(context.self)
         Behaviors.receive {
           (context, message) =>
             message match {
               case IntentionDoneMessage(s) =>
                 context.log.debug(f"${executionContext.name}: an intention was done by $s")
               case IntentionErrorMessage(c,s) =>
                 context.log.debug(f"${executionContext.name}: an intention was done by $s: $c")
               case SubGoalMessage(_, _, _) =>
                 router ! message.asInstanceOf[SubGoalMessage]
               case GoalMessage(m, ref) =>
                 m match {
                   case t: StructTerm =>
                     val subGoal = GoalParser.create_goal_message(t, ref)

                     if (subGoal.isDefined)
                       context.self ! subGoal.get
                     else
                       ref.asInstanceOf[AkkaMessageSource].src ! IntentionErrorMessage(NoPlanMessage(),AkkaMessageSource(executionContext.agent.self))


                 }

                case AskMessage(m, ref) =>
                                m match {
                                  case t: StructTerm =>
                                    val subGoal = GoalParser.create_test_message(t, ref)

                                    if (subGoal.isDefined)
                                      context.self ! subGoal.get
                                    else
                                      ref.asInstanceOf[AkkaMessageSource].src ! IntentionErrorMessage(NoPlanMessage(),AkkaMessageSource(executionContext.agent.self))
                                }
             case BeliefMessage(m, ref) =>
                  m match {
                    case t: StructTerm =>
                    if(executionContext.beliefBase.assertOne(t)) {
                      val subGoal = GoalParser.create_belief_message(t, ref)

                      if (subGoal.isDefined)
                        context.self ! subGoal.get
                    }
                  }

              case UnBeliefMessage(m, ref) =>
                   m match {
                     case t: StructTerm =>
                     if(executionContext.beliefBase.retractOne(t)) {
                       val subGoal = GoalParser.create_unbelief_message(t, ref)

                       if (subGoal.isDefined)
                         context.self ! subGoal.get
                     }
                   }
             }
             Behaviors.same
         }
       }
     }
   }



   object GoalParser extends IAgentGoalParser {
        override def create_goal_message(t: StructTerm, ref: IMessageSource) (implicit executionContext: ExecutionContext): Option[SubGoalMessage] = {
  {
                    Option.empty[SubGoalMessage]
                    }

                }

        override def create_belief_message(t: StructTerm, ref: IMessageSource) (implicit executionContext: ExecutionContext): Option[SubGoalMessage] = {
  {
                    Option.empty[SubGoalMessage]
                    }

                }

         override def create_test_message(t: StructTerm, ref: IMessageSource) (implicit executionContext: ExecutionContext): Option[SubGoalMessage] = {
  {
                            Option.empty[SubGoalMessage]
                            }
                        }
          override def create_unbelief_message(t: StructTerm, ref: IMessageSource) (implicit executionContext: ExecutionContext): Option[SubGoalMessage] = {
  {
                                     Option.empty[SubGoalMessage]
                                     }
                                 }



        }





 }
object agent_companion { 
   def create() = new agent().agentBuilder 
   def create(in_coms : AgentCommunicationLayer) = new agent(coms = in_coms).agentBuilder 
   def create(in_beliefBaseFactory: IBeliefBaseFactory) = new agent(beliefBaseFactory = in_beliefBaseFactory).agentBuilder 
   def create(in_coms : AgentCommunicationLayer, in_beliefBaseFactory: IBeliefBaseFactory) = new agent(coms = in_coms, beliefBaseFactory = in_beliefBaseFactory).agentBuilder 
} 
