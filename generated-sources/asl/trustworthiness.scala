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

 class trustworthiness  (coms: AgentCommunicationLayer = new  DefaultCommunications,
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

                   case trustworthiness.this.adopt_achievement_process_all_agents_and_goals_0 =>
                     trustworthiness.this.adopt_achievement_process_all_agents_and_goals_0.execute(message.params.asInstanceOf[Parameters])

                   case trustworthiness.this.adopt_achievement_acquire_scores_2 =>
                     trustworthiness.this.adopt_achievement_acquire_scores_2.execute(message.params.asInstanceOf[Parameters])

                   case trustworthiness.this.adopt_belief_competence_3 =>
                     trustworthiness.this.adopt_belief_competence_3.execute(message.params.asInstanceOf[Parameters])

                   case trustworthiness.this.adopt_belief_benevolence_offer_4 =>
                     trustworthiness.this.adopt_belief_benevolence_offer_4.execute(message.params.asInstanceOf[Parameters])

                   case trustworthiness.this.adopt_belief_integrity_3 =>
                     trustworthiness.this.adopt_belief_integrity_3.execute(message.params.asInstanceOf[Parameters])

                   case trustworthiness.this.adopt_achievement_maybe_calc_trustworthiness_2 =>
                     trustworthiness.this.adopt_achievement_maybe_calc_trustworthiness_2.execute(message.params.asInstanceOf[Parameters])

                   case trustworthiness.this.adopt_achievement_calc_trustworthiness_2 =>
                     trustworthiness.this.adopt_achievement_calc_trustworthiness_2.execute(message.params.asInstanceOf[Parameters])


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

         override def agent_type: String = "trustworthiness"

         var vars = VarMap()

         def initGoals()(implicit executionContext: ExecutionContext) = List[StructTerm](
                     StructTerm("process_all_agents_and_goals",Seq[GenericTerm](  ))


         )

         def initBeliefs()(implicit executionContext: ExecutionContext) = List[StructTerm](
                     StructTerm("agent",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]())))
           ,
            StructTerm("agent",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]())))
           ,
            StructTerm("agent",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]())))
           ,
            StructTerm("benevolence_offer",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),DoubleTerm(0.7),IntTerm(1)))
           ,
            StructTerm("integrity",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),DoubleTerm(0.9)))
           ,
            StructTerm("total_competence",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),DoubleTerm(0.8),IntTerm(1)))
           ,
            StructTerm("benevolence_offer",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),DoubleTerm(0.5),IntTerm(1)))
           ,
            StructTerm("integrity",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),DoubleTerm(0.85)))
           ,
            StructTerm("total_competence",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),DoubleTerm(0.6),IntTerm(1)))
           ,
            StructTerm("benevolence_offer",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),DoubleTerm(0.8),IntTerm(1)))
           ,
            StructTerm("integrity",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),DoubleTerm(0.85)))
           ,
            StructTerm("total_competence",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),DoubleTerm(0.75),IntTerm(1)))
           ,
            StructTerm("benevolence_offer",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),DoubleTerm(0.6),IntTerm(1)))
           ,
            StructTerm("integrity",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),DoubleTerm(0.9)))
           ,
            StructTerm("total_competence",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),DoubleTerm(0.7),IntTerm(1)))
           ,
            StructTerm("total_competence",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),DoubleTerm(0.9),IntTerm(1)))
           ,
            StructTerm("benevolence_offer",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),DoubleTerm(0.6),IntTerm(1)))
           ,
            StructTerm("integrity",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),DoubleTerm(0.8)))
           ,
            StructTerm("total_competence",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),DoubleTerm(0.6),IntTerm(1)))
           ,
            StructTerm("benevolence_offer",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),DoubleTerm(0.7),IntTerm(1)))
           ,
            StructTerm("integrity",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),DoubleTerm(0.7)))
           ,
            StructTerm("weight_competence",Seq[GenericTerm](DoubleTerm(0.4)))
           ,
            StructTerm("weight_benevolence",Seq[GenericTerm](DoubleTerm(0.6)))
           ,
            StructTerm("weight_integrity",Seq[GenericTerm](DoubleTerm(0.3)))
           ,
            StructTerm("threshold_trustworthiness",Seq[GenericTerm](StructTerm("gardening",Seq[GenericTerm]()),DoubleTerm(0.7)))
           ,
            StructTerm("threshold_trustworthiness",Seq[GenericTerm](StructTerm("cleaning",Seq[GenericTerm]()),DoubleTerm(0.7)))
           ,
            StructTerm(":-",Seq[GenericTerm](StructTerm("benevolence",Seq[GenericTerm](vars("A"),vars("Goal"),vars("AvgB"))),StructTerm(",",Seq[GenericTerm](StructTerm("benevolence_offer",Seq[GenericTerm](vars("A"),vars("Goal"),vars("Bmin"),vars("Bmax"))),StructTerm("is",Seq[GenericTerm](vars("AvgB"),StructTerm("/",Seq[GenericTerm](StructTerm("+",Seq[GenericTerm](vars("Bmin"),vars("Bmax"))),IntTerm(2)))))))))
           ,
            StructTerm(":-",Seq[GenericTerm](StructTerm("competence",Seq[GenericTerm](vars("A"),vars("Goal"),vars("AvgC"))),StructTerm(",",Seq[GenericTerm](StructTerm("total_competence",Seq[GenericTerm](vars("A"),vars("Goal"),vars("Cmin"),vars("Cmax"))),StructTerm("is",Seq[GenericTerm](vars("AvgC"),StructTerm("/",Seq[GenericTerm](StructTerm("+",Seq[GenericTerm](vars("Cmin"),vars("Cmax"))),IntTerm(2)))))))))
           ,
            StructTerm("competence_provider_agent",Seq[GenericTerm](StringTerm("competence")))
           ,
            StructTerm("benevolence_provider_agent",Seq[GenericTerm](StringTerm("benevolence")))
           ,
            StructTerm("integrity_provider_agent",Seq[GenericTerm](StringTerm("integrity")))
           ,
            StructTerm("decision_maker_agent",Seq[GenericTerm](StringTerm("decisionCosinesim")))
           ,
            StructTerm("trutsworthiness_provider_agent",Seq[GenericTerm](StringTerm("trustworthiness")))


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
                                   if(t.matchOnlyFunctorAndArity("process_all_agents_and_goals",0)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_process_all_agents_and_goals_0, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("acquire_scores",2)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_acquire_scores_2, args, ref))
                                   } else     
                                   if(t.matchOnlyFunctorAndArity("maybe_calc_trustworthiness",2)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_maybe_calc_trustworthiness_2, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("calc_trustworthiness",2)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_calc_trustworthiness_2, args, ref))
                                   } else   {
                    Option.empty[SubGoalMessage]
                    }

                }

        override def create_belief_message(t: StructTerm, ref: IMessageSource) (implicit executionContext: ExecutionContext): Option[SubGoalMessage] = {
                    
                                   if(t.matchOnlyFunctorAndArity("competence",3)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_belief_competence_3, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("benevolence_offer",4)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_belief_benevolence_offer_4, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("integrity",3)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_belief_integrity_3, args, ref))
                                   } else     {
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


      object adopt_achievement_process_all_agents_and_goals_0 extends IGoal {

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
                             plan0(vars)
                             return
                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm(": Starting to process all agents and goals for trustworthiness calculation."))))
                                               val ex_L7704 = executionContext.beliefBase.bufferedQuery( StructTerm("agent",Seq[GenericTerm](vars("L7704"))) )
                                               while (ex_L7704.hasNext) {
                                                   val sol_L7704 = ex_L7704.next
                                                   if(sol_L7704.result) {
                                                   vars += ("A" -> sol_L7704.bindings("L7704").asInstanceOf[GenericTerm])
                                                                       PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( (StringTerm(": Processing agent: ") + vars("A")) )))
                                                                            val ex_L19316 = executionContext.beliefBase.bufferedQuery( StructTerm("threshold_trustworthiness",Seq[GenericTerm](vars("L19316"),vars("_"))) )
                                                                            while (ex_L19316.hasNext) {
                                                                                val sol_L19316 = ex_L19316.next
                                                                                if(sol_L19316.result) {
                                                                                vars += ("Goal" -> sol_L19316.bindings("L19316").asInstanceOf[GenericTerm])
                                                                                                    PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( (StringTerm(": Processing goal: ") + vars("Goal"))  + StringTerm(" for agent: "))  + vars("A")) )))
                                                                                                    adopt_achievement_calc_trustworthiness_2.execute(Parameters(List( vars("Agent") , vars("Goal")  )))

                                                                                }
                                                                            }
                                                                        vars -= ("Goal")

                                                   }
                                               }
                                           vars -= ("A")


                     }


      }

      object adopt_achievement_acquire_scores_2 extends IGoal {

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
                          vars +=(   "Goal" -> params.l_params(1))

                         val r0 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("competence_provider_agent",Seq[GenericTerm](vars("CPAgent"))),StructTerm("benevolence_provider_agent",Seq[GenericTerm](vars("BPAgent"))))),StructTerm("integrity_provider_agent",Seq[GenericTerm](vars("IPAgent"))))))

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

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => coms.ask(vars("CPAgent"),StructTerm("competence",Seq[GenericTerm](vars("A"),vars("Goal"),vars("CScore"))))))
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => coms.ask(vars("BPAgent"),StructTerm("benevolence",Seq[GenericTerm](vars("A"),vars("Goal"),vars("BScore"))))))
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => coms.ask(vars("IPAgent"),StructTerm("integrity",Seq[GenericTerm](vars("A"),vars("Goal"),vars("IScore"))))))
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( (StringTerm(": Successfully asked for  all scores for ") + vars("A"))  + StringTerm(", "))  + vars("Goal")) )))


                     }


      }

      object adopt_belief_competence_3 extends IGoal {

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
                          vars +=(   "Goal" -> params.l_params(1))
                          vars +=(   "CScore" -> params.l_params(2))

                             plan0(vars)
                             return
                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( (StringTerm("Received competence for ") + vars("A"))  + StringTerm(" on "))  + vars("Goal"))  + StringTerm(": "))  + vars("CScore")) )))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("competence",Seq[GenericTerm](vars("A"),vars("Goal"),vars("_")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("competence",Seq[GenericTerm](vars("A"),vars("Goal"),vars("CScore")))),GoalParser)
                                          adopt_achievement_maybe_calc_trustworthiness_2.execute(Parameters(List( vars("A") , vars("Goal")  )))


                     }


      }

      object adopt_belief_benevolence_offer_4 extends IGoal {

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
                          vars +=(   "Goal" -> params.l_params(1))
                          vars +=(   "BScoremin" -> params.l_params(2))
                          vars +=(   "BScoremax" -> params.l_params(3))

                         val r0 = executionContext.beliefBase.query(StructTerm("is",Seq[GenericTerm](vars("BScore"),StructTerm("/",Seq[GenericTerm](StructTerm("+",Seq[GenericTerm](vars("BScoremin"),vars("BScoremax"))),IntTerm(2))))))

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

                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("benevolence",Seq[GenericTerm](vars("A"),vars("Goal"),vars("_")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("benevolence",Seq[GenericTerm](vars("A"),vars("Goal"),vars("BScore")))),GoalParser)
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( ( ( ( ( (StringTerm("Received benevolence offer for ") + vars("A"))  + StringTerm(" on "))  + vars("Goal"))  + StringTerm(": min="))  + vars("BScoremin"))  + StringTerm(", max="))  + vars("BScoremax"))  + StringTerm(", mean="))  + vars("BScore")) )))
                                          adopt_achievement_maybe_calc_trustworthiness_2.execute(Parameters(List( vars("A") , vars("Goal")  )))


                     }


      }

      object adopt_belief_integrity_3 extends IGoal {

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
                          vars +=(   "Goal" -> params.l_params(1))
                          vars +=(   "IScore" -> params.l_params(2))

                             plan0(vars)
                             return
                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( (StringTerm("Received integrity for ") + vars("A"))  + StringTerm(" on "))  + vars("Goal"))  + StringTerm(": "))  + vars("IScore")) )))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("integrity",Seq[GenericTerm](vars("A"),vars("Goal"),vars("_")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("integrity",Seq[GenericTerm](vars("A"),vars("Goal"),vars("IScore")))),GoalParser)
                                          adopt_achievement_maybe_calc_trustworthiness_2.execute(Parameters(List( vars("A") , vars("Goal")  )))


                     }


      }

      object adopt_achievement_maybe_calc_trustworthiness_2 extends IGoal {

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
                          vars +=(   "Goal" -> params.l_params(1))

                         val r0 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("competence",Seq[GenericTerm](vars("A"),vars("Goal"),vars("CScore"))),StructTerm("benevolence",Seq[GenericTerm](vars("A"),vars("Goal"),vars("BScore"))))),StructTerm("integrity",Seq[GenericTerm](vars("A"),vars("Goal"),vars("IScore"))))))

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

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( ( ( ( ( (StringTerm(": Successfully acquired all scores for ") + vars("A"))  + StringTerm(", "))  + vars("Goal"))  + StringTerm(". C="))  + vars("CScore"))  + StringTerm(", B="))  + vars("BScore"))  + StringTerm(", I="))  + vars("IScore")) )))
                                          adopt_achievement_calc_trustworthiness_2.execute(Parameters(List( vars("A") , vars("Goal")  )))


                     }


      }

      object adopt_achievement_calc_trustworthiness_2 extends IGoal {

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
                          vars +=(   "Goal" -> params.l_params(1))

                         val r0 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("competence",Seq[GenericTerm](vars("A"),vars("Goal"),vars("C"))),StructTerm("benevolence",Seq[GenericTerm](vars("A"),vars("Goal"),vars("B"))))),StructTerm("integrity",Seq[GenericTerm](vars("A"),vars("Goal"),vars("I"))))),StructTerm("weight_competence",Seq[GenericTerm](vars("WC"))))),StructTerm("weight_benevolence",Seq[GenericTerm](vars("WB"))))),StructTerm("weight_integrity",Seq[GenericTerm](vars("WI"))))),StructTerm("threshold_trustworthiness",Seq[GenericTerm](vars("Goal"),vars("T"))))),StructTerm("decision_maker_agent",Seq[GenericTerm](vars("DMAgent"))))))

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

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( (StringTerm("Calculating trustworthiness for ") + vars("A"))  + StringTerm(" for goal: "))  + vars("Goal")) )))
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( (StringTerm("Competence: ") + vars("C")) )))
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( (StringTerm("Benevolence: ") + vars("B")) )))
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( (StringTerm("Integrity: ") + vars("I")) )))
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( (StringTerm("Weights: ") + vars("WC"))  + StringTerm(", "))  + vars("WB"))  + StringTerm(", "))  + vars("WI")) )))
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( (StringTerm("Threshold: ") + vars("T")) )))
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm("-------------------------------------------------"))))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("trustworthiness",Seq[GenericTerm](vars("A"),vars("Goal"),vars("_"),vars("_")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("untrustworthiness",Seq[GenericTerm](vars("A"),vars("Goal"),vars("_"),vars("_")))),GoalParser)
                                           vars += ("TrustworthinessScore" ->  ( ( ( (vars("C") * vars("WC"))  +  (vars("B") * vars("WB")) )  +  (vars("I") * vars("WI")) )  /  ( (vars("WC") + vars("WB"))  + vars("WI")) ) )
                                           vars += ("UntrustworthinessFactor" ->  (DoubleTerm(1.0) - vars("TrustworthinessScore")) )
                                          if(( ( ( (vars("C") == IntTerm(0))  &&  (vars("B") == IntTerm(0)) )  &&  (vars("I") == IntTerm(0)) ) ).holds) {
                                                                   vars += ("Reason" -> StringTerm("all_zero"))

                                          }
                                                               else if(( ( (vars("C") == IntTerm(0))  &&  (vars("B") == IntTerm(0)) ) ).holds) {
                                                                                          vars += ("Reason" -> StringTerm("competence_benevolence_zero"))

                                                               }
                                                               else if(( ( (vars("C") == IntTerm(0))  &&  (vars("I") == IntTerm(0)) ) ).holds) {
                                                                                          vars += ("Reason" -> StringTerm("competence_integrity_zero"))

                                                               }
                                                               else if(( ( (vars("B") == IntTerm(0))  &&  (vars("I") == IntTerm(0)) ) ).holds) {
                                                                                          vars += ("Reason" -> StringTerm("benevolence_integrity_zero"))

                                                               }
                                                               else if(( (vars("C") == IntTerm(0)) ).holds) {
                                                                                          vars += ("Reason" -> StringTerm("competence_zero"))

                                                               }
                                                               else if(( (vars("B") == IntTerm(0)) ).holds) {
                                                                                          vars += ("Reason" -> StringTerm("benevolence_zero"))

                                                               }
                                                               else if(( (vars("I") == IntTerm(0)) ).holds) {
                                                                                          vars += ("Reason" -> StringTerm("integrity_zero"))

                                                               }
                                                               else if(( (vars("TrustworthinessScore") < vars("T")) ).holds) {
                                                                                          vars += ("Reason" -> StringTerm("below_threshold"))

                                                               }

                                           else {
                                                                   vars += ("Reason" -> StringTerm("above_threshold"))

                                           }
                                          if(( ( ( (vars("C") == IntTerm(0))  ||  (vars("B") == IntTerm(0)) )  ||  (vars("I") == IntTerm(0)) ) ).holds) {
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("untrustworthiness",Seq[GenericTerm](vars("A"),vars("Goal"),vars("UntrustworthinessFactor"),vars("Reason")))),GoalParser)
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( ( (StringTerm("- ") + vars("A"))  + StringTerm(" is NOT trustworthy for the goal: "))  + vars("Goal"))  + StringTerm(" (reason: "))  + vars("Reason"))  + StringTerm(")")) )))
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => coms.inform(vars("DMAgent"),StructTerm("untrustworthiness",Seq[GenericTerm](vars("A"),vars("Goal"),vars("UntrustworthinessFactor"),vars("Reason"))))))

                                          }
                                                               else if(( (vars("TrustworthinessScore") >= vars("T")) ).holds) {
                                                                                          BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("trustworthiness",Seq[GenericTerm](vars("A"),vars("Goal"),vars("TrustworthinessScore"),vars("Reason")))),GoalParser)
                                                                                         PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( ( (StringTerm("- ") + vars("A"))  + StringTerm(" is trustworthy for the goal: "))  + vars("Goal"))  + StringTerm(" (score: "))  + vars("TrustworthinessScore"))  + StringTerm(")")) )))
                                                                                         PrimitiveAction.execute(PrimitiveAction.Parameters(() => coms.inform(vars("DMAgent"),StructTerm("trustworthiness",Seq[GenericTerm](vars("A"),vars("Goal"),vars("TrustworthinessScore"),vars("Reason"))))))

                                                               }

                                           else {
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("untrustworthiness",Seq[GenericTerm](vars("A"),vars("Goal"),vars("UntrustworthinessFactor"),vars("Reason")))),GoalParser)
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( ( (StringTerm("- ") + vars("A"))  + StringTerm(" is NOT trustworthy for the goal: "))  + vars("Goal"))  + StringTerm(" (score: "))  + vars("TrustworthinessScore"))  + StringTerm(")")) )))
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( (StringTerm("- Untrustworthiness factor: ") + vars("UntrustworthinessFactor")) )))
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => coms.inform(vars("DMAgent"),StructTerm("untrustworthiness",Seq[GenericTerm](vars("A"),vars("Goal"),vars("UntrustworthinessFactor"),vars("Reason"))))))

                                           }


                     }


      }





 }
object trustworthiness_companion { 
   def create() = new trustworthiness().agentBuilder 
   def create(in_coms : AgentCommunicationLayer) = new trustworthiness(coms = in_coms).agentBuilder 
   def create(in_beliefBaseFactory: IBeliefBaseFactory) = new trustworthiness(beliefBaseFactory = in_beliefBaseFactory).agentBuilder 
   def create(in_coms : AgentCommunicationLayer, in_beliefBaseFactory: IBeliefBaseFactory) = new trustworthiness(coms = in_coms, beliefBaseFactory = in_beliefBaseFactory).agentBuilder 
} 
