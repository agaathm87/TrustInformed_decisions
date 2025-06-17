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

 class reasoning  (coms: AgentCommunicationLayer = new  DefaultCommunications,
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

                   case reasoning.this.adopt_achievement_is_contradiction_0 =>
                     reasoning.this.adopt_achievement_is_contradiction_0.execute(message.params.asInstanceOf[Parameters])

                   case reasoning.this.adopt_achievement_is_contradiction_3 =>
                     reasoning.this.adopt_achievement_is_contradiction_3.execute(message.params.asInstanceOf[Parameters])

                   case reasoning.this.adopt_belief_belief_3 =>
                     reasoning.this.adopt_belief_belief_3.execute(message.params.asInstanceOf[Parameters])

                   case reasoning.this.adopt_belief_belief_4 =>
                     reasoning.this.adopt_belief_belief_4.execute(message.params.asInstanceOf[Parameters])

                   case reasoning.this.adopt_belief_belief_5 =>
                     reasoning.this.adopt_belief_belief_5.execute(message.params.asInstanceOf[Parameters])

                   case reasoning.this.adopt_belief_belief_6 =>
                     reasoning.this.adopt_belief_belief_6.execute(message.params.asInstanceOf[Parameters])

                   case reasoning.this.adopt_belief_belief_7 =>
                     reasoning.this.adopt_belief_belief_7.execute(message.params.asInstanceOf[Parameters])


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

         override def agent_type: String = "reasoning"

         var vars = VarMap()

         def initGoals()(implicit executionContext: ExecutionContext) = List[StructTerm](
         )

         def initBeliefs()(implicit executionContext: ExecutionContext) = List[StructTerm](
                     StructTerm(":-",Seq[GenericTerm](StructTerm("agent",Seq[GenericTerm](vars("A"))),StructTerm("belief",Seq[GenericTerm](vars("Y"),StructTerm("agent",Seq[GenericTerm]()),vars("A")))))
           ,
            StructTerm(":-",Seq[GenericTerm](StructTerm("trust",Seq[GenericTerm](vars("A"),vars("V"))),StructTerm("belief",Seq[GenericTerm](vars("Y"),StructTerm("trust",Seq[GenericTerm]()),vars("A"),vars("V")))))
           ,
            StructTerm(":-",Seq[GenericTerm](StructTerm("benevolence",Seq[GenericTerm](vars("A"),vars("V"),vars("X1"),vars("X2"))),StructTerm("belief",Seq[GenericTerm](vars("Y"),StructTerm("benevolence",Seq[GenericTerm]()),vars("A"),vars("V"),vars("X1"),vars("X2")))))
           ,
            StructTerm(":-",Seq[GenericTerm](StructTerm("principle",Seq[GenericTerm](vars("P"),vars("X"),vars("V"))),StructTerm("belief",Seq[GenericTerm](vars("Y"),StructTerm("principle",Seq[GenericTerm]()),vars("P"),vars("X"),vars("V")))))
           ,
            StructTerm(":-",Seq[GenericTerm](StructTerm("intention",Seq[GenericTerm](vars("A"),vars("P"))),StructTerm("belief",Seq[GenericTerm](vars("Y"),StructTerm("intention",Seq[GenericTerm]()),vars("A"),vars("P")))))
           ,
            StructTerm(":-",Seq[GenericTerm](StructTerm("offer",Seq[GenericTerm](vars("A"),vars("P1"),vars("P2"),vars("O"))),StructTerm("belief",Seq[GenericTerm](vars("Y"),StructTerm("offer",Seq[GenericTerm]()),vars("A"),vars("P1"),vars("P2"),vars("O")))))
           ,
            StructTerm(":-",Seq[GenericTerm](StructTerm("reject",Seq[GenericTerm](vars("A"),vars("O"),vars("V"))),StructTerm("belief",Seq[GenericTerm](vars("Y"),StructTerm("reject",Seq[GenericTerm]()),vars("A"),vars("O"),vars("V")))))
           ,
            StructTerm(":-",Seq[GenericTerm](StructTerm("accept",Seq[GenericTerm](vars("A"),vars("O"))),StructTerm("belief",Seq[GenericTerm](vars("Y"),StructTerm("accept",Seq[GenericTerm]()),vars("A"),vars("O")))))
           ,
            StructTerm(":-",Seq[GenericTerm](StructTerm("succes",Seq[GenericTerm](vars("A"),vars("P"))),StructTerm("belief",Seq[GenericTerm](vars("Y"),StructTerm("succes",Seq[GenericTerm]()),vars("A"),vars("P")))))
           ,
            StructTerm(":-",Seq[GenericTerm](StructTerm("failure",Seq[GenericTerm](vars("A"),vars("P"),vars("C"))),StructTerm("belief",Seq[GenericTerm](vars("Y"),StructTerm("failure",Seq[GenericTerm]()),vars("A"),vars("P"),vars("C")))))
           ,
            StructTerm(":-",Seq[GenericTerm](StructTerm("value",Seq[GenericTerm](vars("A"),vars("V"),vars("P"),vars("X"))),StructTerm("belief",Seq[GenericTerm](vars("Y"),StructTerm("value",Seq[GenericTerm]()),vars("A"),vars("V"),vars("P"),vars("X")))))
           ,
            StructTerm(":-",Seq[GenericTerm](StructTerm("value",Seq[GenericTerm](vars("A"),vars("V"),vars("X"))),StructTerm("belief",Seq[GenericTerm](vars("Y"),StructTerm("value",Seq[GenericTerm]()),vars("A"),vars("V"),vars("X")))))
           ,
            StructTerm(":-",Seq[GenericTerm](StructTerm("subplan",Seq[GenericTerm](vars("P1"),vars("P2"))),StructTerm("belief",Seq[GenericTerm](vars("Y"),StructTerm("subplan",Seq[GenericTerm]()),vars("P1"),vars("P2")))))
           ,
            StructTerm(":-",Seq[GenericTerm](StructTerm("knowledge",Seq[GenericTerm](vars("A"),vars("P"),vars("C"),vars("X"))),StructTerm("belief",Seq[GenericTerm](vars("Y"),StructTerm("knowledge",Seq[GenericTerm]()),vars("A"),vars("P"),vars("C"),vars("X")))))
           ,
            StructTerm(":-",Seq[GenericTerm](StructTerm("resource",Seq[GenericTerm](vars("A"),vars("P"),vars("C"),vars("X"))),StructTerm("belief",Seq[GenericTerm](vars("Y"),StructTerm("resource",Seq[GenericTerm]()),vars("A"),vars("P"),vars("C"),vars("X")))))
           ,
            StructTerm(":-",Seq[GenericTerm](StructTerm("skill",Seq[GenericTerm](vars("A"),vars("P"),vars("C"),vars("X"))),StructTerm("belief",Seq[GenericTerm](vars("Y"),StructTerm("skill",Seq[GenericTerm]()),vars("A"),vars("P"),vars("C"),vars("X")))))


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
                                   if(t.matchOnlyFunctorAndArity("is_contradiction",0)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_is_contradiction_0, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("is_contradiction",3)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_is_contradiction_3, args, ref))
                                   } else        {
                    Option.empty[SubGoalMessage]
                    }

                }

        override def create_belief_message(t: StructTerm, ref: IMessageSource) (implicit executionContext: ExecutionContext): Option[SubGoalMessage] = {
                    
                                   if(t.matchOnlyFunctorAndArity("belief",3)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_belief_belief_3, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("belief",4)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_belief_belief_4, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("belief",5)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_belief_belief_5, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("belief",6)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_belief_belief_6, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("belief",7)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_belief_belief_7, args, ref))
                                   } else   {
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


      object adopt_achievement_is_contradiction_0 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         val r0 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm("belief",Seq[GenericTerm](vars("Y1"),StructTerm("accept",Seq[GenericTerm]()),vars("A"),vars("B"))),StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("reject",Seq[GenericTerm]()),vars("A"),vars("B"),vars("C"))))))

                         if (r0.result) {
                             r0.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan0(vars)
                             return
                          }

                          // plan 0 end



                 //plan 1 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         val r1 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("belief",Seq[GenericTerm](vars("Y1"),StructTerm("failure",Seq[GenericTerm]()),vars("A"),vars("Plan"),vars("B"))),StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("succes",Seq[GenericTerm]()),vars("A"),vars("Plan"))))),StructTerm("is",Seq[GenericTerm](vars("Y3a"),StructTerm("*",Seq[GenericTerm](StructTerm("-",Seq[GenericTerm](IntTerm(1),StructTerm("-",Seq[GenericTerm](vars("Y2"),vars("Y1"))))),StructTerm("/",Seq[GenericTerm](StructTerm("+",Seq[GenericTerm](vars("Y1"),vars("Y2"))),IntTerm(2))))))))),StructTerm("is",Seq[GenericTerm](vars("Y3b"),StructTerm("*",Seq[GenericTerm](StructTerm("-",Seq[GenericTerm](IntTerm(1),StructTerm("-",Seq[GenericTerm](vars("Y1"),vars("Y2"))))),StructTerm("/",Seq[GenericTerm](StructTerm("+",Seq[GenericTerm](vars("Y1"),vars("Y2"))),IntTerm(2))))))))))

                         if (r1.result) {
                             r1.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan1(vars)
                             return
                          }

                          // plan 1 end



                 //plan 2 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         val r2 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("belief",Seq[GenericTerm](vars("Y1"),vars("Offer"),vars("A"),vars("Plan"))),StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("notOffer",Seq[GenericTerm]()),vars("A"),vars("Plan"))))),StructTerm("is",Seq[GenericTerm](vars("Y3a"),StructTerm("*",Seq[GenericTerm](StructTerm("-",Seq[GenericTerm](IntTerm(1),StructTerm("-",Seq[GenericTerm](vars("Y2"),vars("Y1"))))),StructTerm("/",Seq[GenericTerm](StructTerm("+",Seq[GenericTerm](vars("Y1"),vars("Y2"))),IntTerm(2))))))))),StructTerm("is",Seq[GenericTerm](vars("Y3b"),StructTerm("*",Seq[GenericTerm](StructTerm("-",Seq[GenericTerm](IntTerm(1),StructTerm("-",Seq[GenericTerm](vars("Y1"),vars("Y2"))))),StructTerm("/",Seq[GenericTerm](StructTerm("+",Seq[GenericTerm](vars("Y1"),vars("Y2"))),IntTerm(2))))))))))

                         if (r2.result) {
                             r2.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan2(vars)
                             return
                          }

                          // plan 2 end



                 //plan 3 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         val r3 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("belief",Seq[GenericTerm](vars("Y1"),StructTerm("value",Seq[GenericTerm]()),vars("A"),vars("B"),vars("C"),vars("D"))),StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("value",Seq[GenericTerm]()),vars("A"),vars("B"),vars("C"),vars("E"))))),StructTerm("\\=",Seq[GenericTerm](vars("D"),vars("E"))))),StructTerm("is",Seq[GenericTerm](vars("Y3a"),StructTerm("*",Seq[GenericTerm](StructTerm("-",Seq[GenericTerm](IntTerm(1),StructTerm("-",Seq[GenericTerm](vars("Y2"),vars("Y1"))))),StructTerm("/",Seq[GenericTerm](StructTerm("+",Seq[GenericTerm](vars("Y1"),vars("Y2"))),IntTerm(2))))))))),StructTerm("is",Seq[GenericTerm](vars("Y3b"),StructTerm("*",Seq[GenericTerm](StructTerm("-",Seq[GenericTerm](IntTerm(1),StructTerm("-",Seq[GenericTerm](vars("Y1"),vars("Y2"))))),StructTerm("/",Seq[GenericTerm](StructTerm("+",Seq[GenericTerm](vars("Y1"),vars("Y2"))),IntTerm(2))))))))),StructTerm("is",Seq[GenericTerm](vars("F"),StructTerm("/",Seq[GenericTerm](StructTerm("+",Seq[GenericTerm](StructTerm("*",Seq[GenericTerm](vars("Y1"),vars("D"))),StructTerm("*",Seq[GenericTerm](vars("Y2"),vars("E"))))),StructTerm("+",Seq[GenericTerm](vars("Y1"),vars("Y2"))))))))))

                         if (r3.result) {
                             r3.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan3(vars)
                             return
                          }

                          // plan 3 end



                 //plan 4 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         val r4 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm("belief",Seq[GenericTerm](vars("Y1"),StructTerm("failure",Seq[GenericTerm]()),vars("A"),vars("Plan"),vars("B"))),StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("succes",Seq[GenericTerm]()),vars("A"),vars("Plan"))))))

                         if (r4.result) {
                             r4.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan4(vars)
                             return
                          }

                          // plan 4 end



                 //plan 5 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         val r5 = executionContext.beliefBase.query(StructTerm(";",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("belief",Seq[GenericTerm](vars("Y1"),StructTerm("mighthave",Seq[GenericTerm]()),vars("A"),vars("B"))),StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("hasnot",Seq[GenericTerm]()),vars("A"),vars("B"))))),StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("has",Seq[GenericTerm]()),vars("A"),vars("B"))))))

                         if (r5.result) {
                             r5.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan5(vars)
                             return
                          }

                          // plan 5 end



                 //plan 6 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         val r6 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm("belief",Seq[GenericTerm](vars("Y1"),StructTerm("competent",Seq[GenericTerm]()),vars("A"),vars("B"))),StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("incompetent",Seq[GenericTerm]()),vars("A"),vars("B"))))))

                         if (r6.result) {
                             r6.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan6(vars)
                             return
                          }

                          // plan 6 end



                 //plan 7 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         val r7 = executionContext.beliefBase.query(StructTerm(";",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("belief",Seq[GenericTerm](vars("Y1"),StructTerm("unknown",Seq[GenericTerm]()),vars("A"),vars("B"))),StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("incompetent",Seq[GenericTerm]()),vars("A"),vars("B"))))),StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("competent",Seq[GenericTerm]()),vars("A"),vars("B"))))))

                         if (r7.result) {
                             r7.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan7(vars)
                             return
                          }

                          // plan 7 end



                 //plan 8 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         val r8 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("belief",Seq[GenericTerm](vars("Y1"),StructTerm("value",Seq[GenericTerm]()),vars("A"),vars("B"),vars("C"),vars("D"))),StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("value",Seq[GenericTerm]()),vars("A"),vars("B"),vars("C"),vars("E"))))),StructTerm("\\=",Seq[GenericTerm](vars("D"),vars("E"))))),StructTerm("is",Seq[GenericTerm](vars("F"),StructTerm("/",Seq[GenericTerm](StructTerm("+",Seq[GenericTerm](StructTerm("*",Seq[GenericTerm](vars("Y1"),vars("D"))),StructTerm("*",Seq[GenericTerm](vars("Y2"),vars("E"))))),StructTerm("+",Seq[GenericTerm](vars("Y1"),vars("Y2"))))))))))

                         if (r8.result) {
                             r8.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan8(vars)
                             return
                          }

                          // plan 8 end



                 //plan 9 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         val r9 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm("belief",Seq[GenericTerm](vars("Y1"),StructTerm("accept",Seq[GenericTerm]()),vars("A"),vars("B"))),StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("reject",Seq[GenericTerm]()),vars("A"),vars("B"),vars("C"))))))

                         if (r9.result) {
                             r9.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan9(vars)
                             return
                          }

                          // plan 9 end



                 //plan 10 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         val r10 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm("belief",Seq[GenericTerm](vars("Y1"),StructTerm("failure",Seq[GenericTerm]()),vars("A"),vars("Plan"),vars("B"))),StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("succes",Seq[GenericTerm]()),vars("A"),vars("Plan"))))))

                         if (r10.result) {
                             r10.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan10(vars)
                             return
                          }

                          // plan 10 end



                 //plan 11 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         val r11 = executionContext.beliefBase.query(StructTerm(";",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("belief",Seq[GenericTerm](vars("Y1"),StructTerm("mighthave",Seq[GenericTerm]()),vars("A"),vars("B"))),StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("hasnot",Seq[GenericTerm]()),vars("A"),vars("B"))))),StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("has",Seq[GenericTerm]()),vars("A"),vars("B"))))))

                         if (r11.result) {
                             r11.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan11(vars)
                             return
                          }

                          // plan 11 end



                 //plan 12 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         val r12 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm("belief",Seq[GenericTerm](vars("Y1"),StructTerm("competent",Seq[GenericTerm]()),vars("A"),vars("B"))),StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("incompetent",Seq[GenericTerm]()),vars("A"),vars("B"))))))

                         if (r12.result) {
                             r12.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan12(vars)
                             return
                          }

                          // plan 12 end



                 //plan 13 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         val r13 = executionContext.beliefBase.query(StructTerm(";",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("belief",Seq[GenericTerm](vars("Y1"),StructTerm("unknown",Seq[GenericTerm]()),vars("A"),vars("B"))),StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("incompetent",Seq[GenericTerm]()),vars("A"),vars("B"))))),StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("competent",Seq[GenericTerm]()),vars("A"),vars("B"))))))

                         if (r13.result) {
                             r13.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan13(vars)
                             return
                          }

                          // plan 13 end



                 //plan 14 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         val r14 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("belief",Seq[GenericTerm](vars("Y1"),StructTerm("value",Seq[GenericTerm]()),vars("A"),vars("B"),vars("C"),vars("D"))),StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("value",Seq[GenericTerm]()),vars("A"),vars("B"),vars("C"),vars("E"))))),StructTerm("\\=",Seq[GenericTerm](vars("D"),vars("E"))))),StructTerm("is",Seq[GenericTerm](vars("F"),StructTerm("/",Seq[GenericTerm](StructTerm("+",Seq[GenericTerm](StructTerm("*",Seq[GenericTerm](vars("Y1"),vars("D"))),StructTerm("*",Seq[GenericTerm](vars("Y2"),vars("E"))))),StructTerm("+",Seq[GenericTerm](vars("Y1"),vars("Y2"))))))))))

                         if (r14.result) {
                             r14.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan14(vars)
                             return
                          }

                          // plan 14 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          if(( (vars("Y1") > vars("Y2")) ).holds) {
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("reject",Seq[GenericTerm]()),vars("A"),vars("B"),vars("C")))),GoalParser)
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm("Contradiction."))))

                                          }
                                                               else if(( (vars("Y2") > vars("Y1")) ).holds) {
                                                                                          BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y1"),StructTerm("accept",Seq[GenericTerm]()),vars("A"),vars("B")))),GoalParser)
                                                                                         PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm("Contradiction."))))

                                                               }

                                          adopt_achievement_is_contradiction_0.execute(Parameters(List(  )))


                     }
                      def plan1(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y1"),StructTerm("failure",Seq[GenericTerm]()),vars("A"),vars("Plan"),vars("B")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("succes",Seq[GenericTerm]()),vars("A"),vars("Plan")))),GoalParser)
                                          if(( (vars("Y1") > vars("Y2")) ).holds) {
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("belief",Seq[GenericTerm](vars("Y3b"),StructTerm("succes",Seq[GenericTerm]()),vars("A"),vars("Plan")))),GoalParser)

                                          }
                                                               else if(( (vars("Y2") > vars("Y1")) ).holds) {
                                                                                          BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("belief",Seq[GenericTerm](vars("Y3a"),StructTerm("failure",Seq[GenericTerm]()),vars("A"),vars("Plan"),vars("B")))),GoalParser)

                                                               }

                                          adopt_achievement_is_contradiction_0.execute(Parameters(List(  )))


                     }
                      def plan2(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y1"),vars("Offer"),vars("A"),vars("Plan")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("notOffer",Seq[GenericTerm]()),vars("A"),vars("Plan")))),GoalParser)
                                          if(( (vars("Y1") > vars("Y2")) ).holds) {
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("belief",Seq[GenericTerm](vars("Y3b"),vars("Offer"),vars("A"),vars("Plan")))),GoalParser)

                                          }
                                                               else if(( (vars("Y2") > vars("Y1")) ).holds) {
                                                                                          BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("belief",Seq[GenericTerm](vars("Y3a"),StructTerm("notOffer",Seq[GenericTerm]()),vars("A"),vars("Plan")))),GoalParser)

                                                               }

                                          adopt_achievement_is_contradiction_0.execute(Parameters(List(  )))


                     }
                      def plan3(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y1"),StructTerm("value",Seq[GenericTerm]()),vars("A"),vars("B"),vars("C"),vars("D")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("value",Seq[GenericTerm]()),vars("A"),vars("B"),vars("C"),vars("E")))),GoalParser)
                                          if(( ( (vars("Y2") - vars("Y1"))  > IntTerm(0)) ).holds) {
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("belief",Seq[GenericTerm](vars("Y3a"),StructTerm("value",Seq[GenericTerm]()),vars("A"),vars("B"),vars("C"),vars("F")))),GoalParser)

                                          }
                                           else {
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("belief",Seq[GenericTerm](vars("Y3b"),StructTerm("value",Seq[GenericTerm]()),vars("A"),vars("B"),vars("C"),vars("F")))),GoalParser)

                                           }
                                          adopt_achievement_is_contradiction_0.execute(Parameters(List(  )))


                     }
                      def plan4(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          if(( (vars("Y1") > vars("Y2")) ).holds) {
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("succes",Seq[GenericTerm]()),vars("A"),vars("Plan")))),GoalParser)
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm("Contradiction."))))

                                          }
                                                               else if(( (vars("Y2") > vars("Y1")) ).holds) {
                                                                                          BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y1"),StructTerm("failure",Seq[GenericTerm]()),vars("A"),vars("Plan"),vars("B")))),GoalParser)
                                                                                         PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm("Contradiction"))))

                                                               }

                                          adopt_achievement_is_contradiction_0.execute(Parameters(List(  )))


                     }
                      def plan5(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          if(( (vars("Y1") > vars("Y2")) ).holds) {
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("hasnot",Seq[GenericTerm]()),vars("A"),vars("B")))),GoalParser)
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("has",Seq[GenericTerm]()),vars("A"),vars("B")))),GoalParser)
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm("Contradiction."))))

                                          }
                                                               else if(( (vars("Y2") > vars("Y1")) ).holds) {
                                                                                          BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y1"),StructTerm("mighthave",Seq[GenericTerm]()),vars("A"),vars("B")))),GoalParser)
                                                                                         PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm("Contradiction"))))

                                                               }

                                          adopt_achievement_is_contradiction_0.execute(Parameters(List(  )))


                     }
                      def plan6(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          if(( (vars("Y1") > vars("Y2")) ).holds) {
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("incompetent",Seq[GenericTerm]()),vars("A"),vars("B")))),GoalParser)
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm("Contradiction."))))

                                          }
                                                               else if(( (vars("Y2") > vars("Y1")) ).holds) {
                                                                                          BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y1"),StructTerm("competent",Seq[GenericTerm]()),vars("A"),vars("B")))),GoalParser)
                                                                                         PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm("Contradiction"))))

                                                               }

                                          adopt_achievement_is_contradiction_0.execute(Parameters(List(  )))


                     }
                      def plan7(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          if(( (vars("Y1") > vars("Y2")) ).holds) {
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("incompetent",Seq[GenericTerm]()),vars("A"),vars("B")))),GoalParser)
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("competent",Seq[GenericTerm]()),vars("A"),vars("B")))),GoalParser)
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm("Contradiction."))))

                                          }
                                                               else if(( (vars("Y2") > vars("Y1")) ).holds) {
                                                                                          BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y1"),StructTerm("unknown",Seq[GenericTerm]()),vars("A"),vars("B")))),GoalParser)
                                                                                         PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm("Contradiction"))))

                                                               }

                                          adopt_achievement_is_contradiction_0.execute(Parameters(List(  )))


                     }
                      def plan8(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm("There was a contradiction between something."))))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y1"),StructTerm("value",Seq[GenericTerm]()),vars("A"),vars("B"),vars("C"),vars("D")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("value",Seq[GenericTerm]()),vars("A"),vars("B"),vars("C"),vars("E")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("belief",Seq[GenericTerm](vars("Y1"),StructTerm("value",Seq[GenericTerm]()),vars("A"),vars("B"),vars("C"),vars("F")))),GoalParser)
                                          adopt_achievement_is_contradiction_0.execute(Parameters(List(  )))


                     }
                      def plan9(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          if(( (vars("Y1") > vars("Y2")) ).holds) {
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("reject",Seq[GenericTerm]()),vars("A"),vars("B"),vars("C")))),GoalParser)
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm("Contradiction."))))

                                          }
                                                               else if(( (vars("Y2") > vars("Y1")) ).holds) {
                                                                                          BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y1"),StructTerm("accept",Seq[GenericTerm]()),vars("A"),vars("B")))),GoalParser)
                                                                                         PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm("Contradiction."))))

                                                               }

                                          adopt_achievement_is_contradiction_0.execute(Parameters(List(  )))


                     }
                      def plan10(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          if(( (vars("Y1") > vars("Y2")) ).holds) {
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("succes",Seq[GenericTerm]()),vars("A"),vars("Plan")))),GoalParser)
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm("Contradiction."))))

                                          }
                                                               else if(( (vars("Y2") > vars("Y1")) ).holds) {
                                                                                          BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y1"),StructTerm("failure",Seq[GenericTerm]()),vars("A"),vars("Plan"),vars("B")))),GoalParser)
                                                                                         PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm("Contradiction"))))

                                                               }

                                          adopt_achievement_is_contradiction_0.execute(Parameters(List(  )))


                     }
                      def plan11(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          if(( (vars("Y1") > vars("Y2")) ).holds) {
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("hasnot",Seq[GenericTerm]()),vars("A"),vars("B")))),GoalParser)
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("has",Seq[GenericTerm]()),vars("A"),vars("B")))),GoalParser)
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm("Contradiction."))))

                                          }
                                                               else if(( (vars("Y2") > vars("Y1")) ).holds) {
                                                                                          BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y1"),StructTerm("mighthave",Seq[GenericTerm]()),vars("A"),vars("B")))),GoalParser)
                                                                                         PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm("Contradiction"))))

                                                               }

                                          adopt_achievement_is_contradiction_0.execute(Parameters(List(  )))


                     }
                      def plan12(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          if(( (vars("Y1") > vars("Y2")) ).holds) {
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("incompetent",Seq[GenericTerm]()),vars("A"),vars("B")))),GoalParser)
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm("Contradiction."))))

                                          }
                                                               else if(( (vars("Y2") > vars("Y1")) ).holds) {
                                                                                          BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y1"),StructTerm("competent",Seq[GenericTerm]()),vars("A"),vars("B")))),GoalParser)
                                                                                         PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm("Contradiction"))))

                                                               }

                                          adopt_achievement_is_contradiction_0.execute(Parameters(List(  )))


                     }
                      def plan13(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          if(( (vars("Y1") > vars("Y2")) ).holds) {
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("incompetent",Seq[GenericTerm]()),vars("A"),vars("B")))),GoalParser)
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("competent",Seq[GenericTerm]()),vars("A"),vars("B")))),GoalParser)
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm("Contradiction."))))

                                          }
                                                               else if(( (vars("Y2") > vars("Y1")) ).holds) {
                                                                                          BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y1"),StructTerm("unknown",Seq[GenericTerm]()),vars("A"),vars("B")))),GoalParser)
                                                                                         PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm("Contradiction"))))

                                                               }

                                          adopt_achievement_is_contradiction_0.execute(Parameters(List(  )))


                     }
                      def plan14(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm("There was a contradiction between something."))))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y1"),StructTerm("value",Seq[GenericTerm]()),vars("A"),vars("B"),vars("C"),vars("D")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("value",Seq[GenericTerm]()),vars("A"),vars("B"),vars("C"),vars("E")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("belief",Seq[GenericTerm](vars("Y1"),StructTerm("value",Seq[GenericTerm]()),vars("A"),vars("B"),vars("C"),vars("F")))),GoalParser)
                                          adopt_achievement_is_contradiction_0.execute(Parameters(List(  )))


                     }


      }

      object adopt_achievement_is_contradiction_3 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Rumour1" -> params.l_params(1))
                          vars +=(   "Rumour2" -> params.l_params(2))

                         val r0 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("belief",Seq[GenericTerm](vars("Y1"),StructTerm("principle",Seq[GenericTerm]()),vars("A"),vars("B"),vars("C"))),StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("principle",Seq[GenericTerm]()),vars("A"),vars("B"),vars("D"))))),StructTerm("\\=",Seq[GenericTerm](vars("C"),vars("D"))))),StructTerm("is",Seq[GenericTerm](vars("E"),StructTerm("/",Seq[GenericTerm](StructTerm("+",Seq[GenericTerm](StructTerm("*",Seq[GenericTerm](vars("Y1"),vars("C"))),StructTerm("*",Seq[GenericTerm](vars("Y2"),vars("D"))))),StructTerm("+",Seq[GenericTerm](vars("Y1"),vars("Y2"))))))))))

                         if (r0.result) {
                             r0.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan0(vars)
                             return
                          }

                          // plan 0 end



                 //plan 1 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Rumour1" -> params.l_params(1))
                          vars +=(   "Rumour2" -> params.l_params(2))

                         val r1 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("belief",Seq[GenericTerm](vars("Y1"),StructTerm("principle",Seq[GenericTerm]()),vars("A"),vars("B"),vars("C"))),StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("principle",Seq[GenericTerm]()),vars("A"),vars("B"),vars("D"))))),StructTerm("\\=",Seq[GenericTerm](vars("C"),vars("D"))))),StructTerm("is",Seq[GenericTerm](vars("E"),StructTerm("/",Seq[GenericTerm](StructTerm("+",Seq[GenericTerm](StructTerm("*",Seq[GenericTerm](vars("Y1"),vars("C"))),StructTerm("*",Seq[GenericTerm](vars("Y2"),vars("D"))))),StructTerm("+",Seq[GenericTerm](vars("Y1"),vars("Y2"))))))))))

                         if (r1.result) {
                             r1.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan1(vars)
                             return
                          }

                          // plan 1 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm("There was a contradiction between something."))))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y1"),StructTerm("principle",Seq[GenericTerm]()),vars("A"),vars("B"),vars("C")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("principle",Seq[GenericTerm]()),vars("A"),vars("B"),vars("D")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("belief",Seq[GenericTerm](vars("Y1"),StructTerm("principle",Seq[GenericTerm]()),vars("A"),vars("B"),vars("E")))),GoalParser)
                                          adopt_achievement_is_contradiction_0.execute(Parameters(List(  )))


                     }
                      def plan1(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm("There was a contradiction between something."))))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y1"),StructTerm("principle",Seq[GenericTerm]()),vars("A"),vars("B"),vars("C")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("principle",Seq[GenericTerm]()),vars("A"),vars("B"),vars("D")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("belief",Seq[GenericTerm](vars("Y1"),StructTerm("principle",Seq[GenericTerm]()),vars("A"),vars("B"),vars("E")))),GoalParser)
                                          adopt_achievement_is_contradiction_0.execute(Parameters(List(  )))


                     }


      }

      object adopt_belief_belief_3 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "Y" -> params.l_params(0))
                          vars +=(   "Z" -> params.l_params(1))
                          vars +=(   "A" -> params.l_params(2))

                         val r0 = executionContext.beliefBase.query(StructTerm("trust",Seq[GenericTerm](vars("Y"),vars("X"))))

                         if (r0.result) {
                             r0.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan0(vars)
                             return
                          }

                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y"),vars("Z"),vars("A")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("belief",Seq[GenericTerm](vars("X"),vars("Z"),vars("A")))),GoalParser)
                                          adopt_achievement_is_contradiction_0.execute(Parameters(List(  )))


                     }


      }

      object adopt_belief_belief_4 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "Y" -> params.l_params(0))
                          vars +=(   "Z" -> params.l_params(1))
                          vars +=(   "A" -> params.l_params(2))
                          vars +=(   "B" -> params.l_params(3))

                         val r0 = executionContext.beliefBase.query(StructTerm("trust",Seq[GenericTerm](vars("Y"),vars("X"))))

                         if (r0.result) {
                             r0.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan0(vars)
                             return
                          }

                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y"),vars("Z"),vars("A"),vars("B")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("belief",Seq[GenericTerm](vars("X"),vars("Z"),vars("A"),vars("B")))),GoalParser)
                                          adopt_achievement_is_contradiction_0.execute(Parameters(List(  )))


                     }


      }

      object adopt_belief_belief_5 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "Y" -> params.l_params(0))
                          vars +=(   "Z" -> params.l_params(1))
                          vars +=(   "A" -> params.l_params(2))
                          vars +=(   "B" -> params.l_params(3))
                          vars +=(   "C" -> params.l_params(4))

                         val r0 = executionContext.beliefBase.query(StructTerm("trust",Seq[GenericTerm](vars("Y"),vars("X"))))

                         if (r0.result) {
                             r0.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan0(vars)
                             return
                          }

                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y"),vars("Z"),vars("A"),vars("B"),vars("C")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("belief",Seq[GenericTerm](vars("X"),vars("Z"),vars("A"),vars("B"),vars("C")))),GoalParser)
                                          adopt_achievement_is_contradiction_0.execute(Parameters(List(  )))


                     }


      }

      object adopt_belief_belief_6 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "Y" -> params.l_params(0))
                          vars +=(   "Z" -> params.l_params(1))
                          vars +=(   "A" -> params.l_params(2))
                          vars +=(   "B" -> params.l_params(3))
                          vars +=(   "C" -> params.l_params(4))
                          vars +=(   "D" -> params.l_params(5))

                         val r0 = executionContext.beliefBase.query(StructTerm("trust",Seq[GenericTerm](vars("Y"),vars("X"))))

                         if (r0.result) {
                             r0.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan0(vars)
                             return
                          }

                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y"),vars("Z"),vars("A"),vars("B"),vars("C"),vars("D")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("belief",Seq[GenericTerm](vars("X"),vars("Z"),vars("A"),vars("B"),vars("C"),vars("D")))),GoalParser)
                                          adopt_achievement_is_contradiction_0.execute(Parameters(List(  )))


                     }


      }

      object adopt_belief_belief_7 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "Y" -> params.l_params(0))
                          vars +=(   "Z" -> params.l_params(1))
                          vars +=(   "A" -> params.l_params(2))
                          vars +=(   "B" -> params.l_params(3))
                          vars +=(   "C" -> params.l_params(4))
                          vars +=(   "D" -> params.l_params(5))
                          vars +=(   "E" -> params.l_params(6))

                         val r0 = executionContext.beliefBase.query(StructTerm("trust",Seq[GenericTerm](vars("Y"),vars("X"))))

                         if (r0.result) {
                             r0.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan0(vars)
                             return
                          }

                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y"),vars("Z"),vars("A"),vars("B"),vars("C"),vars("D"),vars("E")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("belief",Seq[GenericTerm](vars("X"),vars("Z"),vars("A"),vars("B"),vars("C"),vars("D"),vars("E")))),GoalParser)
                                          adopt_achievement_is_contradiction_0.execute(Parameters(List(  )))


                     }


      }





 }
object reasoning_companion { 
   def create() = new reasoning().agentBuilder 
   def create(in_coms : AgentCommunicationLayer) = new reasoning(coms = in_coms).agentBuilder 
   def create(in_beliefBaseFactory: IBeliefBaseFactory) = new reasoning(beliefBaseFactory = in_beliefBaseFactory).agentBuilder 
   def create(in_coms : AgentCommunicationLayer, in_beliefBaseFactory: IBeliefBaseFactory) = new reasoning(coms = in_coms, beliefBaseFactory = in_beliefBaseFactory).agentBuilder 
} 
