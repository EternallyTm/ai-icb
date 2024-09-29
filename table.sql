/*
 Navicat Premium Dump SQL

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80402 (8.4.2)
 Source Host           : localhost:3306
 Source Schema         : ai_icb

 Target Server Type    : MySQL
 Target Server Version : 80402 (8.4.2)
 File Encoding         : 65001

 Date: 29/09/2024 10:54:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for icb_chat_messages
-- ----------------------------
DROP TABLE IF EXISTS `icb_chat_messages`;
CREATE TABLE `icb_chat_messages`  (
                                      `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键',
                                      `user_id` bigint NOT NULL COMMENT '会话用户ID',
                                      `session_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '会话ID',
                                      `sender_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '发送者ID，根据sender_type区分botId还是用户的userId',
                                      `sender_type` int NOT NULL COMMENT '消息发送类型：1-user,2-bot',
                                      `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '消息内容',
                                      `message_type` int NOT NULL DEFAULT 1 COMMENT '1-text 2-image 3-file',
                                      `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
                                      PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of icb_chat_messages
-- ----------------------------
INSERT INTO `icb_chat_messages` VALUES ('6WrH2B1XBx99kdAW2XasW2uN4pZwQ1UV', 5, 'hBpdrLjgLRg8LuUsAbOyPQiIffIWupnF', '5', 1, '给我推荐一下月子餐搭配', 1, '2024-09-20 18:13:04');
INSERT INTO `icb_chat_messages` VALUES ('AxxaQDkIiBwKrYGV9BE6qBe1eMSLUdHA', 5, 'QONZQpW8SIpjrPE36k4ID32lEo6qmRRT', '5', 1, '阳光玫瑰', 1, '2024-09-20 22:50:28');
INSERT INTO `icb_chat_messages` VALUES ('jI6RiBtZjYFRjXBnytWzT3T33VuRRYWn', 5, 'QONZQpW8SIpjrPE36k4ID32lEo6qmRRT', 'jI6RiBtZjYFRjXBnytWzT3T33VuRRYWn', 2, '阳关玫瑰（Sunflower Rose）并非一个常见的专业术语，在历史聊天记录或当前的提问中，这个表达并没有直接指向某个特定的AI技术或概念。因此，我会先尝试从文化和常识角度来解释这个词汇。\n\n\"阳关\"一词在中国文化中通常与阳光、积极、开朗等积极的意象相关联。\"玫瑰\"则常常象征着爱情、美丽和浪漫。结合两者，\"阳关玫瑰\"可能是指某种寓意着阳光、美好、爱的象征物或概念。\n\n由于这个表达并不直接对应某个AI技术术语，以下是根据上述工作流程提供的答案：\n\n1. 分析用户当前问题：用户询问\"阳关玫瑰是什么？\"，关键信息为\"阳关玫瑰\"。\n\n2. 结合历史聊天记录：由于历史聊天记录中已有相同问题的询问，且没有其他上下文信息，我们可以推测用户可能是在寻求一个具体的解释或定义。\n\n3. 提供个性化回答：\n   - 技术定义：从技术角度来看，\"阳关玫瑰\"并不是一个定义明确的术语。如果这是一个特定项目或产品的名称，那么可能需要更多的上下文信息来给出准确的解释。\n   - 原理：由于这个词汇并不直接关联到某个AI技术，原理部分无法直接应用。但如果我们将它视为某种创意表达或艺术作品，可以说它可能是基于对阳光、自然和美好情感的抽象表达。\n   - 应用案例：在现实世界中，\"阳关玫瑰\"这样的概念可能会被用于艺术创作、文学作品或品牌命名，用以传达积极、温暖和爱的主题。\n\n4. 如果问题与AI技术无关：正如本例所示，\"阳关玫瑰\"并非一个AI技术相关的术语，因此我的回答是从文化和常识角度出发的。\n\n综上，如果\"阳关玫瑰\"是一个特定领域的术语或特定项目的名称，请提供更多的上下文信息，以便我能给出更准确和专业的解释。', 1, '2024-09-20 18:20:20');
INSERT INTO `icb_chat_messages` VALUES ('lhVsinrFhBpQJ4HrM3wRcj63Rc6hqPMS', 5, '2wqfy2mf4C2pTumdCzTyx4DZDAQNuQqI', 'lhVsinrFhBpQJ4HrM3wRcj63Rc6hqPMS', 2, '由于您之前的对话记录并没有具体说明是哪一类技术问题，我将基于当前您提出的问题“帮我解决一个技术问题”进行一般性的回答。\n\n在AI领域，当我们谈及“解决技术问题”，通常指的是应用人工智能技术来处理特定的挑战或需求。以下是针对这一通用请求的详细回答：\n\n**技术定义：**\n技术问题通常指的是在科学、工程、IT等领域中遇到的具体障碍或难点，这些问题可能涉及硬件、软件、算法、数据处理、系统集成等多个方面。\n\n**原理：**\n在AI领域，解决技术问题的原理通常包括数据收集、模型训练、算法优化和结果验证等步骤。\n\n1. **数据收集：** 确保拥有高质量、相关性强的数据集，这对于训练有效的AI模型至关重要。\n2. **模型训练：** 选择适当的机器学习或深度学习模型，并通过喂食数据来训练模型，使其能够识别模式、做出预测或执行特定任务。\n3. **算法优化：** 根据模型的表现调整算法参数，以提高模型的准确率、效率或其他关键指标。\n4. **结果验证：** 在独立的数据集上测试模型，确保其泛化能力强，能够可靠地解决实际问题。\n\n**应用案例：**\n以下是AI技术解决技术问题的几个应用案例：\n\n1. **医疗影像诊断：** 使用深度学习模型分析医学影像，辅助医生诊断疾病。\n   - **问题：** 识别肿瘤和其他异常组织的准确率低。\n   - **解决方案：** 利用卷积神经网络（CNN）训练模型，提高诊断的准确性。\n\n2. **自然语言处理（NLP）：** 在客户服务中应用聊天机器人，以自动回答客户的问题。\n   - **问题：** 聊天机器人无法理解复杂或模糊的自然语言表达。\n   - **解决方案：** 使用循环神经网络（RNN）和变压器（Transformer）模型来提高语言理解能力。\n\n3. **自动驾驶：** 使用AI技术处理来自各种传感器的数据，实现车辆的自动驾驶。\n   - **问题：** 在复杂交通环境中，如何做出快速而安全的驾驶决策。\n   - **解决方案：** 结合深度强化学习和传感器融合技术，提升车辆的感知能力和决策速度。\n\n为了更具体地帮助您解决技术问题，请提供更多关于您所面临的技术挑战的详细信息。这样，我才能提供更加专业和个性化的建议。', 1, '2024-09-20 18:08:37');
INSERT INTO `icb_chat_messages` VALUES ('ocRUnmzAqfryT9kjxch9ROS3hxl5QHj7', 5, 'DZGhfwqiyl3UO8xhOeOluA3NPUjyt667', '5', 1, '给我推荐一个月子餐搭配', 1, '2024-09-20 18:16:58');
INSERT INTO `icb_chat_messages` VALUES ('q2BCeSdIKIZhwYrx0mOFD2KPgYuHHZxs', 5, '2wqfy2mf4C2pTumdCzTyx4DZDAQNuQqI', '5', 1, 'const handleSendStreamMessage = async (messages: { content: any; }[]) => {\n    const messageParam: SendMessageParam = {\n      sessionId: sessionIdRef.current,\n      modelName: \"zhipu-glm4-online\",\n      content: messages[messages.length - 1].content\n    };\n\n    try {\n      const token = localStorage.getItem(AUTH_TOKEN_KEY) || \'\';\n      // 正常业务中如下:\n      const response = await fetch(\'/api/chat/message/v1/stream-send-message\', {\n        method: \'POST\',\n        headers: {\n          \'Content-Type\': \'application/json\',\n          \'auth-token\': token\n        },\n        body: JSON.stringify(messageParam),\n      });\n\n      console.log(\'response：\', response);\n\n      if (!response.ok || !response.body) {\n        return {\n          content: \"服务器错误，请稍后重试~\",\n          id: \'xxxx\',\n          role: \'user-King\',\n          keys: [\'Ovo\'],\n        };\n      }\n\n      // 获取 reader\n      const reader = response.body.getReader();\n      const decoder = new TextDecoder(\'utf-8\');\n      const encoder = new TextEncoder();\n\n      const readableStream = new ReadableStream({\n        async start(controller) {\n          let buffer = \'\';  // 用于存储尚未解析完的chunk数据\n\n          function push() {\n            reader\n              .read()\n              .then(({ done, value }) => {\n                if (done) {\n                  controller.close();\n                  return;\n                }\n\n                // 读取chunk并解码\n                const chunk = decoder.decode(value, { stream: true });\n                buffer += chunk;  // 累积未处理的数据\n\n                // 按行分割，处理多个`data:`消息\n                let parts = buffer.split(/\\r?\\n/);  // 按换行符分割\n\n                // 最后一部分可能是不完整的，需要保留到下一次处理\n                buffer = parts.pop() || \'\';\n\n                parts.forEach(part => {\n                  if (part.startsWith(\'data: \')) {\n                    const jsonData = part.replace(\'data: \', \'\');\n\n                    try {\n                      const parsed = JSON.parse(jsonData);\n                      controller.enqueue(encoder.encode(parsed.content)); // 推送解析的消息内容\n                    } catch (error) {\n                      console.error(\'JSON解析错误:\', error);\n                    }\n                  }\n                });\n\n                push();  // 递归调用，继续读取下一段流数据\n              })\n              .catch((err: any) => {\n                console.error(\'读取流中的数据时发生错误\', err);\n                controller.error(err);\n              });\n          }\n\n          push();  // 启动流处理\n        },\n      });\n\n      return new Response(readableStream);\n\n    } catch (error) {\n      console.error(\'Error sending message:\', error);\n      return {\n        content: \"发送消息时发生错误，请稍后重试~\",\n        id: \'send-error\',\n        role: \'assistant\',\n        createAt: Date.now()\n      };\n    }\n  } 这段代码如何判定为程序执行接入', 1, '2024-09-20 18:10:09');
INSERT INTO `icb_chat_messages` VALUES ('Rrzake2C4GwLio8sd95dnHoAU4w2AvsH', 5, 'hBpdrLjgLRg8LuUsAbOyPQiIffIWupnF', 'Rrzake2C4GwLio8sd95dnHoAU4w2AvsH', 2, '从您的历史聊天记录和当前问题来看，您似乎对月子餐搭配感兴趣。然而，这个问题并不直接涉及AI技术。不过，作为AI技术顾问，我可以尝试从技术角度来提供一些相关的见解。\n\n月子餐搭配通常是指为产后恢复期的母亲准备的营养餐食。虽然这个问题本身不涉及AI技术，但AI可以在以下方面为月子餐搭配提供支持：\n\n### 技术定义：\n\n**AI在饮食搭配中的应用**：利用机器学习算法，尤其是推荐系统，根据个人的营养需求、口味偏好、健康情况等因素，为其提供个性化的饮食建议。\n\n### 原理：\n\n1. **数据收集**：通过问卷、健康监测设备等收集个人的健康数据、饮食习惯等信息。\n2. **算法分析**：使用机器学习算法分析用户数据，识别营养需求和潜在的健康风险。\n3. **推荐生成**：根据分析结果，AI系统会推荐符合个人需求的食谱和食材。\n4. **反馈调整**：用户可以根据自己的反馈调整推荐结果，AI系统持续学习和优化。\n\n### 应用案例：\n\n在月子餐搭配中，AI技术可以：\n\n1. **个性化推荐**：根据产后妈妈的体质、恢复阶段、营养需求，AI可以推荐适合的餐食。\n2. **营养监测**：监测妈妈的营养摄入情况，确保母乳喂养的宝宝获得充足的营养。\n3. **健康管理**：通过分析饮食数据，AI可以帮助预防产后贫血、肥胖等健康问题。\n4. **智能食谱**：AI可以根据妈妈的口味和食材可用性，提供多样化的食谱。\n\n结合以上信息，虽然AI在月子餐搭配的直接应用不是非常普遍，但这项技术具有很大的潜力，可以帮助产后母亲更好地恢复和照顾新生儿。\n\n对于您的具体需求，我建议寻找专业的营养师进行面对面的咨询，以获得最符合您个人情况的月子餐搭配建议。同时，也可以关注一些结合了AI技术的健康管理和饮食推荐应用，它们可能会提供一定的帮助。', 1, '2024-09-20 18:13:19');
INSERT INTO `icb_chat_messages` VALUES ('TNqd6uI7IXm0XuuUdhznHCridWu3WWek', 5, 'QONZQpW8SIpjrPE36k4ID32lEo6qmRRT', '5', 1, '阳关玫瑰是什么？', 1, '2024-09-20 18:20:06');
INSERT INTO `icb_chat_messages` VALUES ('vmWTE1aLvD2hqySi2Z5LHDbxCUUFdxHl', 5, '2wqfy2mf4C2pTumdCzTyx4DZDAQNuQqI', '5', 1, '帮我解决一个技术问题', 1, '2024-09-20 18:08:20');
INSERT INTO `icb_chat_messages` VALUES ('VXzNfDEh1Y2TZlCVEA8VDMJgCKYxz1L5', 5, 'QONZQpW8SIpjrPE36k4ID32lEo6qmRRT', 'VXzNfDEh1Y2TZlCVEA8VDMJgCKYxz1L5', 2, '结合历史聊天记录和当前的提问“阳光玫瑰”，我理解这可能是一个特定的名词，但它在AI技术术语中并不常见。如果这是用户想要了解的一个概念或者是某种特定的产品名称，我将基于以下方面来提供答案：\n\n1. 技术定义：\n   \"阳光玫瑰\"在技术领域不是一个标准的术语。但如果我们假设这是一个比喻或者某种产品、项目的名称，它可能在形象地描述某种技术的特性或寓意。例如，它可能是指一种以阳光般的温暖和积极特性为设计理念的技术产品或服务。\n\n2. 原理：\n   如果我们从技术的角度来构想“阳光玫瑰”，它可能涉及到以下几个技术原理：\n   - “阳光”可能代表光照技术，例如在植物生长灯或太阳能技术中的应用。\n   - “玫瑰”可能象征美丽和精致，指的是某种注重外观设计和用户体验的技术。\n   - 将两者结合，可能是一个集成了节能环保、美观实用一体的技术创新。\n\n3. 应用案例：\n   - 在智能家居领域，\"阳光玫瑰\"可能是一个品牌的名称，代表着一种模拟自然阳光的光照系统，旨在为用户提供舒适、健康的居住环境。\n   - 在农业技术中，\"阳光玫瑰\"或许是一个新型的LED植物生长灯系列，它能够模拟阳光的光谱，帮助植物在室内环境中健康成长。\n   - 在艺术与科技结合的领域，\"阳光玫瑰\"可能是一个艺术装置的名称，利用高科技手段展现阳光与花卉之美。\n\n4. 如果问题与AI技术无关：\n   如果“阳光玫瑰”与AI技术确实无关，那么上述答案是从可能的应用场景出发进行的合理推测。如果用户意图了解其他方面的“阳光玫瑰”，请提供更多信息，以便我能提供更精确的回答。\n\n根据上述分析，如果“阳光玫瑰”是用户对某个具体概念的代称或者是一个特定产品的名称，我建议提供更多细节，以便我能够提供更为精确和深入的技术解释。', 1, '2024-09-20 22:50:43');
INSERT INTO `icb_chat_messages` VALUES ('yqYY7jRqUenFz4FaVVT5m9KhQUzsDrgg', 5, 'DZGhfwqiyl3UO8xhOeOluA3NPUjyt667', 'yqYY7jRqUenFz4FaVVT5m9KhQUzsDrgg', 2, '根据您之前的问题和当前的提问，看起来您对月子餐搭配很感兴趣。月子餐是指产后女性为了调养身体而特别准备的饮食。以下是根据您的需求，结合AI技术在营养搭配方面的应用，提供的个性化月子餐搭配建议：\n\n### 技术定义\n月子餐搭配是根据产后女性的身体恢复需求，结合营养学和中医理论，通过合理搭配食物种类和比例，达到调养身体、促进恢复的目的。\n\n### 原理\n1. **营养均衡**：AI技术可以通过分析个体的身体数据（如体重、年龄、体质等），推荐营养均衡的餐食。\n2. **中医理论**：结合中医的体质学说，AI系统可以推荐适合不同体质的产后女性的食物。\n3. **数据驱动**：通过收集和分析大量产后恢复的数据，AI能够优化餐单，使其更具个性化。\n\n### 应用案例\n以下是一个基于AI技术推荐的月子餐搭配案例：\n\n- **早餐**：燕麦粥（富含膳食纤维，有助于消化），搭配鸡蛋和牛奶（优质蛋白质来源），以及适量的坚果（提供必需脂肪酸）。\n  \n- **午餐**：瘦肉（如鸡肉、鱼肉，有助于身体恢复），搭配蔬菜（提供维生素和矿物质），五谷杂粮（提供能量和膳食纤维）。\n  \n- **晚餐**：豆腐炖汤（植物蛋白，易于吸收），搭配小米粥（温和易消化），以及适量的海产品（提供碘和其他微量元素）。\n\n- **加餐**：新鲜水果（补充维生素），以及一些有助于下奶的汤水，如花生猪脚汤。\n\n### 个性化调整\n考虑到您可能对某些食物有偏好或禁忌，建议使用具有AI功能的营养搭配软件，输入您的个人喜好和身体恢复情况，以获得更贴合您需求的餐单。\n\n请注意，这些建议仅供参考，实际月子餐搭配应结合产后女性的具体情况，并在专业营养师的指导下进行。', 1, '2024-09-20 18:17:12');

-- ----------------------------
-- Table structure for icb_chat_sessions
-- ----------------------------
DROP TABLE IF EXISTS `icb_chat_sessions`;
CREATE TABLE `icb_chat_sessions`  (
                                      `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键',
                                      `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '聊天标题',
                                      `user_id` bigint NOT NULL COMMENT '聊天用户ID',
                                      `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                      PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of icb_chat_sessions
-- ----------------------------
INSERT INTO `icb_chat_sessions` VALUES ('2wqfy2mf4C2pTumdCzTyx4DZDAQNuQqI', '\"解决技术问题\"。', 5, '2024-09-20 10:08:20');
INSERT INTO `icb_chat_sessions` VALUES ('DZGhfwqiyl3UO8xhOeOluA3NPUjyt667', '\"推荐月子餐搭配\"。', 5, '2024-09-20 10:16:58');
INSERT INTO `icb_chat_sessions` VALUES ('hBpdrLjgLRg8LuUsAbOyPQiIffIWupnF', '\"推荐月子餐搭配\"。', 5, '2024-09-20 10:13:04');
INSERT INTO `icb_chat_sessions` VALUES ('QONZQpW8SIpjrPE36k4ID32lEo6qmRRT', '\"阳关玫瑰\"是一种特定类型的玫瑰或指代具有特定寓意的事物。由于“阳关”通常与阳光、积极含义相关，这里可能指的是寓意阳光、积极的玫瑰品种或象征。具体需结合语境理解。', 5, '2024-09-20 10:20:06');

-- ----------------------------
-- Table structure for icb_company
-- ----------------------------
DROP TABLE IF EXISTS `icb_company`;
CREATE TABLE `icb_company`  (
                                `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
                                `name` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '企业名称',
                                `unified_social_code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '统一社会信用代码',
                                `status` int NOT NULL COMMENT '企业状态：0-待审核 1-审核通过 2-审核拒绝',
                                `admin_user_id` bigint NOT NULL COMMENT '管理员账号ID',
                                `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                `created_by` bigint NOT NULL COMMENT '创建人',
                                `updated_at` timestamp NULL DEFAULT NULL COMMENT '更新时间',
                                `updated_by` bigint NULL DEFAULT NULL,
                                PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '企业表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of icb_company
-- ----------------------------
INSERT INTO `icb_company` VALUES (1, '平台', '111111111111111111', 1, 1, '2024-04-08 23:00:34', 1, NULL, NULL);

-- ----------------------------
-- Table structure for icb_knowledge_base
-- ----------------------------
DROP TABLE IF EXISTS `icb_knowledge_base`;
CREATE TABLE `icb_knowledge_base`  (
                                       `id` bigint NOT NULL AUTO_INCREMENT COMMENT '知识库主键',
                                       `kb_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '知识库名称',
                                       `kb_info` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '知识库简介（用于agent）',
                                       `kb_name_pinyin` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '知识库名称的拼音',
                                       `vs_type` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '向量数据库类型',
                                       `embed_model` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '嵌入模型名称',
                                       `file_count` int NOT NULL DEFAULT 0 COMMENT '文件数量',
                                       `user_id` bigint NOT NULL DEFAULT 0 COMMENT '知识库所属用户ID(为0表示平台知识库)',
                                       `type` int NOT NULL DEFAULT 1 COMMENT '知识库类型：1-私有知识库 2-共有知识库（平台提供）',
                                       `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                       `created_by` bigint NOT NULL COMMENT '创建人',
                                       `updated_at` timestamp NULL DEFAULT NULL COMMENT '更新时间',
                                       `updated_by` bigint NULL DEFAULT NULL COMMENT '更新人',
                                       PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '知识库基础信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of icb_knowledge_base
-- ----------------------------
INSERT INTO `icb_knowledge_base` VALUES (12, '知识库', '测试知识库1', 'ZSK', 'faiss', 'zhipu-glm4-online', 0, 5, 1, '2024-09-27 22:28:06', 5, '2024-09-27 22:28:13', 5);
INSERT INTO `icb_knowledge_base` VALUES (14, '新增知识库', '新增一个知识库', 'XZZSK', 'faiss', 'zhipu-glm4-online', 0, 5, 1, '2024-09-27 22:41:41', 5, '2024-09-27 22:41:41', 5);
INSERT INTO `icb_knowledge_base` VALUES (15, '怎么测试userId为0', '打发士大夫', 'ZMCSUSERIDW0', 'faiss', 'zhipu-glm4-online', 0, 5, 1, '2024-09-27 22:53:54', 5, '2024-09-27 22:53:54', 5);

-- ----------------------------
-- Table structure for icb_knowledge_file
-- ----------------------------
DROP TABLE IF EXISTS `icb_knowledge_file`;
CREATE TABLE `icb_knowledge_file`  (
                                       `id` bigint NOT NULL AUTO_INCREMENT COMMENT '知识文件Id',
                                       `file_name_pinyin` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文件名拼音',
                                       `file_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文件名',
                                       `file_ext` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文件扩展名',
                                       `user_id` bigint NOT NULL DEFAULT 0 COMMENT '知识库所属用户ID',
                                       `kb_id` bigint NULL DEFAULT NULL COMMENT '所属知识库ID',
                                       `document_loader_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文档加载器名称',
                                       `text_splitter_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文档分割器名称',
                                       `file_version` int NOT NULL DEFAULT 1 COMMENT ' 文件版本',
                                       `file_size` int NOT NULL DEFAULT 0 COMMENT '文件大小',
                                       `file_mtime` float NULL DEFAULT NULL COMMENT '文件修改时间',
                                       `docs_count` int NOT NULL DEFAULT 1 COMMENT '拆分的文档数量',
                                       `custom_docs` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否是自定义文档',
                                       `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                       `created_by` bigint NOT NULL DEFAULT 0 COMMENT '创建人',
                                       `updated_at` timestamp NULL DEFAULT NULL COMMENT '更新时间',
                                       `updated_by` bigint NULL DEFAULT NULL COMMENT '更新人',
                                       PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '知识文件' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of icb_knowledge_file
-- ----------------------------

-- ----------------------------
-- Table structure for icb_knowledge_file_doc
-- ----------------------------
DROP TABLE IF EXISTS `icb_knowledge_file_doc`;
CREATE TABLE `icb_knowledge_file_doc`  (
                                           `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
                                           `kb_id` bigint NOT NULL COMMENT '所属知识库主键',
                                           `file_name_pinyin` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                                           `file_name` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文档名称',
                                           `doc_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '向量库文档ID',
                                           `meta_data` json NULL COMMENT '元数据信息，默认为{}',
                                           PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 53 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '文件-向量库文档' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of icb_knowledge_file_doc
-- ----------------------------

-- ----------------------------
-- Table structure for icb_menu
-- ----------------------------
DROP TABLE IF EXISTS `icb_menu`;
CREATE TABLE `icb_menu`  (
                             `id` bigint NOT NULL AUTO_INCREMENT,
                             `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '菜单名称',
                             `pid` bigint NOT NULL DEFAULT 0 COMMENT '父菜单ID，一级菜单为0',
                             `use_scenes` int NOT NULL COMMENT '使用场景：1-管理端 2-用户端',
                             `path` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '菜单路由路径',
                             `redirect` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
                             `perms` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
                             `type` int NULL DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
                             `status` int NOT NULL DEFAULT 1 COMMENT '是否显示 0-不显示，1-显示',
                             `icon` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '菜单图标',
                             `hidden` bit(1) NOT NULL DEFAULT b'1' COMMENT '是否隐藏：0-显示，1-隐藏',
                             `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '数据的层级结构：按上级id加,号分割',
                             `order_num` int NULL DEFAULT NULL COMMENT '排序',
                             `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                             `created_by` bigint NOT NULL COMMENT '创建人',
                             `updated_at` timestamp NULL DEFAULT NULL COMMENT '更行时间',
                             `updated_by` bigint NULL DEFAULT NULL COMMENT '更新人',
                             PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '菜单表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of icb_menu
-- ----------------------------
INSERT INTO `icb_menu` VALUES (4, '权限管理', 0, 1, '/authorization', '/authorization/menu', NULL, 0, 1, NULL, b'0', '0,4', 2, '2024-04-07 17:30:22', 1, NULL, NULL);
INSERT INTO `icb_menu` VALUES (5, '菜单管理', 4, 1, '/authorization/menu', '', NULL, 1, 1, NULL, b'0', '0,4,5', 1, '2024-04-07 17:32:40', 1, '2024-06-13 21:32:46', 1);
INSERT INTO `icb_menu` VALUES (6, '角色管理', 4, 1, '/authorization/role', '', '', 1, 1, NULL, b'0', '0,4,6', 2, '2024-04-07 23:34:49', 1, '2024-06-13 21:34:38', 1);
INSERT INTO `icb_menu` VALUES (9, '账户管理', 0, 2, '/account', NULL, NULL, 0, 1, NULL, b'1', '0,9', 1, '2024-06-13 20:53:09', 1, '2024-06-13 21:35:24', 1);
INSERT INTO `icb_menu` VALUES (10, '用户管理', 9, 2, '/account/user', NULL, NULL, 1, 1, NULL, b'1', '0,9,10', 1, '2024-06-13 21:06:25', 1, '2024-06-13 21:36:08', 1);
INSERT INTO `icb_menu` VALUES (11, '企业管理', 9, 2, '/account/company', NULL, NULL, 1, 1, NULL, b'1', '0,9,11', 2, '2024-06-13 21:07:58', 1, '2024-06-13 21:36:01', 1);
INSERT INTO `icb_menu` VALUES (12, '聊天', 0, 2, '/chat', NULL, NULL, 1, 1, NULL, b'1', '0,12', 4, '2024-06-16 19:13:20', 6, NULL, NULL);

-- ----------------------------
-- Table structure for icb_model
-- ----------------------------
DROP TABLE IF EXISTS `icb_model`;
CREATE TABLE `icb_model`  (
                              `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
                              `name_cn` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '模型名称-中文',
                              `name_en` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '模型名称-英文',
                              `mode` int NOT NULL COMMENT '部署方式：1-在线大模型 2-私有大模型',
                              `type` int NOT NULL COMMENT '模型类型：1-大语言模型 2-embedding模型',
                              `model_path` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '模型地址：私有大模型类型下，模型路径',
                              `online_provider` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '公有模型的provider',
                              `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                              `created_by` bigint NOT NULL COMMENT '创建人',
                              `updated_at` timestamp NULL DEFAULT NULL COMMENT '更新时间',
                              `updated_by` bigint NULL DEFAULT NULL COMMENT '更新人',
                              PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '模型表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of icb_model
-- ----------------------------
INSERT INTO `icb_model` VALUES (1, '智普GLM4-在线', 'zhipu-glm4-online', 1, 1, NULL, NULL, '2024-09-01 14:40:39', 5, NULL, NULL);

-- ----------------------------
-- Table structure for icb_role
-- ----------------------------
DROP TABLE IF EXISTS `icb_role`;
CREATE TABLE `icb_role`  (
                             `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
                             `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色名称',
                             `status` int NOT NULL DEFAULT 1 COMMENT '角色状态：0-禁用 1-启用',
                             `company_id` bigint NOT NULL COMMENT '企业id: 企业下自定义角色时存在',
                             `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
                             `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                             `created_by` bigint NOT NULL COMMENT '创建人',
                             `updated_at` timestamp NULL DEFAULT NULL COMMENT '更新时间',
                             `updated_by` bigint NULL DEFAULT NULL,
                             PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of icb_role
-- ----------------------------
INSERT INTO `icb_role` VALUES (1, 'admin', 1, 1, NULL, '2024-06-13 21:22:25', 1, '2024-06-16 19:14:12', 6);
INSERT INTO `icb_role` VALUES (3, '测试第二个角色', 1, 1, '测试第三个角色', '2024-06-14 14:36:29', 1, '2024-06-14 14:36:29', 1);

-- ----------------------------
-- Table structure for icb_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `icb_role_menu`;
CREATE TABLE `icb_role_menu`  (
                                  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
                                  `role_id` bigint NOT NULL COMMENT '角色ID',
                                  `menu_id` bigint NOT NULL COMMENT '菜单ID',
                                  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 72 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色-菜单关系表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of icb_role_menu
-- ----------------------------
INSERT INTO `icb_role_menu` VALUES (63, 3, 10);
INSERT INTO `icb_role_menu` VALUES (64, 3, 11);
INSERT INTO `icb_role_menu` VALUES (65, 3, 5);
INSERT INTO `icb_role_menu` VALUES (66, 3, 6);
INSERT INTO `icb_role_menu` VALUES (67, 1, 6);
INSERT INTO `icb_role_menu` VALUES (68, 1, 5);
INSERT INTO `icb_role_menu` VALUES (69, 1, 11);
INSERT INTO `icb_role_menu` VALUES (70, 1, 10);
INSERT INTO `icb_role_menu` VALUES (71, 1, 12);

-- ----------------------------
-- Table structure for icb_role_user
-- ----------------------------
DROP TABLE IF EXISTS `icb_role_user`;
CREATE TABLE `icb_role_user`  (
                                  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
                                  `role_id` bigint NOT NULL COMMENT '角色ID',
                                  `user_id` bigint NOT NULL COMMENT '用户ID',
                                  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色-菜单关系表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of icb_role_user
-- ----------------------------
INSERT INTO `icb_role_user` VALUES (9, 1, 5);
INSERT INTO `icb_role_user` VALUES (12, 1, 6);
INSERT INTO `icb_role_user` VALUES (13, 1, 8);

-- ----------------------------
-- Table structure for icb_sys_log
-- ----------------------------
DROP TABLE IF EXISTS `icb_sys_log`;
CREATE TABLE `icb_sys_log`  (
                                `id` bigint NOT NULL AUTO_INCREMENT,
                                `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户名',
                                `operation` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户操作',
                                `method` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '请求方法',
                                `params` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '请求参数',
                                `time` bigint NOT NULL COMMENT '执行时长(毫秒)',
                                `ip` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'IP地址',
                                `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '系统日志' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of icb_sys_log
-- ----------------------------

-- ----------------------------
-- Table structure for icb_user
-- ----------------------------
DROP TABLE IF EXISTS `icb_user`;
CREATE TABLE `icb_user`  (
                             `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
                             `name` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户姓名',
                             `username` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '登录名：默认使用邮箱作为登录名',
                             `email` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '邮箱',
                             `mobile` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '手机号',
                             `status` int NOT NULL COMMENT '0-未启用 1-已启用',
                             `type` int NOT NULL COMMENT '账号类型：1-运营账号 2-外部账号',
                             `company_id` bigint NULL DEFAULT NULL COMMENT '企业code,外部企业账号时不为空',
                             `password` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
                             `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                             `created_by` bigint NOT NULL COMMENT '创建人',
                             `updated_at` timestamp NULL DEFAULT NULL COMMENT '更新时间',
                             `updated_by` bigint NULL DEFAULT NULL,
                             PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of icb_user
-- ----------------------------
INSERT INTO `icb_user` VALUES (5, '管理员', 'admin', '1028106567@qq.com', '15071229750', 1, 1, 1, '885a5baa6267ceccdc330420984498b12666ab816006dcd81ad077d4cbcc26fa', '2024-06-16 12:28:35', 1, NULL, NULL);
INSERT INTO `icb_user` VALUES (6, '管理员2', 'admin2', '1028106558@qq.com', '8888888884', 1, 1, 1, '885a5baa6267ceccdc330420984498b12666ab816006dcd81ad077d4cbcc26fa', '2024-06-16 12:34:39', 5, '2024-06-16 12:39:34', 6);
INSERT INTO `icb_user` VALUES (8, '管理员3', 'admin3', '1028106559@qq.com', '18888888887', 1, 1, 1, '885a5baa6267ceccdc330420984498b12666ab816006dcd81ad077d4cbcc26fa', '2024-06-16 12:40:18', 6, NULL, NULL);

-- ----------------------------
-- Table structure for icb_user_model_config
-- ----------------------------
DROP TABLE IF EXISTS `icb_user_model_config`;
CREATE TABLE `icb_user_model_config`  (
                                          `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
                                          `model_id` bigint NOT NULL COMMENT '基础模型ID',
                                          `app_key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '如果是在线模型，则需要appKey',
                                          `user_id` bigint NOT NULL COMMENT '所属用户ID',
                                          `temperature` float NOT NULL DEFAULT 0.8 COMMENT '大模型采样温度',
                                          `max_tokens` int NOT NULL DEFAULT 1024 COMMENT '限制LLM生成Token数量，默认None代表模型最大值',
                                          `history_len` int NOT NULL DEFAULT 5 COMMENT '从数据库中取历史消息的数量',
                                          PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of icb_user_model_config
-- ----------------------------
INSERT INTO `icb_user_model_config` VALUES (1, 1, '01add86cfbcd0490e0fb0de5d061bc3a.UKQMnp5a9YNXE8Vj', 5, 0.8, 1024, 5);

SET FOREIGN_KEY_CHECKS = 1;
